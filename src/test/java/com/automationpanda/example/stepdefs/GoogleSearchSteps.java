package com.automationpanda.example.stepdefs;

import com.automationpanda.example.pages.GooglePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSearchSteps {

    private WebDriver driver;
    private GooglePage googlePage;

    @Before(value = "@web", order = 1)
    public void initWebDriver() throws Throwable {
        driver = new ChromeDriver();
    }

    @Before(value = "@google", order = 10)
    public void initGooglePage() throws Throwable {
        googlePage = new GooglePage(driver);
    }

    @Given("^a web browser is on the Google page$")
    public void aWebBrowserIsOnTheGooglePage() throws Throwable {
        googlePage.navigateToHomePage();
    }

    @When("^the search phrase \"([^\"]*)\" is entered$")
    public void theSearchPhraseIsEntered(String phrase) throws Throwable {
        googlePage.enterSearchPhrase(phrase);
    }

    @Then("^results for \"([^\"]*)\" are shown$")
    public void resultsForAreShown(String phrase) throws Throwable {
        assertThat(googlePage.pageTitleContains(phrase)).isTrue();
    }

    @After
    public void disposeWebDriver() throws Throwable {
        driver.quit();
    }
}
