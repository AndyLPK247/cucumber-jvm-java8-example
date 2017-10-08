package com.automationpanda.example.stepdefs;

import com.automationpanda.example.pages.GooglePage;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSearchSteps implements En {

    private WebDriver driver;
    private GooglePage googlePage;

    public GoogleSearchSteps() {
        Before(new String[]{"@web"}, 1000, 1, (Scenario scenario) -> {
            driver = new ChromeDriver();
        });
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
}
