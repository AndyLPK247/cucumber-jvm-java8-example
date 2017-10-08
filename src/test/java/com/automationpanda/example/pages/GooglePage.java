package com.automationpanda.example.pages;

import com.automationpanda.example.framework.AbstractPandaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePage extends AbstractPandaPage {

    private static final String GOOGLE_HOME_URL = "https://www.google.com/";
    private static final By BY_SEARCH_FIELD = By.name("q");

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        getDriver().navigate().to(GOOGLE_HOME_URL);
    }

    public void enterSearchPhrase(String phrase) {
        WebElement searchField = driverWait(10).until(ExpectedConditions.elementToBeClickable(BY_SEARCH_FIELD));
        searchField.sendKeys(phrase);
        searchField.submit();
    }

    public boolean pageTitleContains(String phrase) {
        try {
            return driverWait(5).until(ExpectedConditions.titleContains(phrase));
        } catch (TimeoutException ex) {
            return false;
        }
    }
}
