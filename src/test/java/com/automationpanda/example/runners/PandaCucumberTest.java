package com.automationpanda.example.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "junit:target/cucumber.xml"},
        features = "src/test/resources/com/automationpanda/example/features",
        glue = {"com.automationpanda.example.stepdefs"})
public class PandaCucumberTest {
}
