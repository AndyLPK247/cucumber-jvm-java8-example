package com.automationpanda.example.stepdefs;

import com.automationpanda.example.pages.GooglePage;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSearchSteps implements En {

    private WebDriver driver;
    private GooglePage googlePage;

    public GoogleSearchSteps() {

        // TODO: Possible Cucumber-JVM bug?
        // For some reason, the following lambda-style Before hook has a problem:
        // The web driver instance it starts cannot be quit in the after hook.
        // If the web driver instance is created using a traditional annotation-style hook,
        // Then there are no problems.

//        Before(new String[]{"@web"}, 1000, 1, (Scenario scenario) -> {
//            driver = new ChromeDriver();
//        });

        Before(new String[]{"@google"}, 1000, 10, (Scenario scenario) -> {
            googlePage = new GooglePage(driver);
        });
        Given("^a web browser is on the Google page$", () -> {
            googlePage.navigateToHomePage();
        });
        When("^the search phrase \"([^\"]*)\" is entered$", (String phrase) -> {
            googlePage.enterSearchPhrase(phrase);
        });
        Then("^results for \"([^\"]*)\" are shown$", (String phrase) -> {
            assertThat(googlePage.pageTitleContains(phrase)).isTrue();
        });
        After(new String[]{"@web"}, (Scenario scenario) -> {
            driver.quit();
        });
    }

    // TODO: This annotation-style Before hook is required as per the explanation above

    @Before(value = "@web", order = 1)
    public void initWebDriver() throws Throwable {
        driver = new ChromeDriver();
    }

}
