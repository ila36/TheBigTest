package com.test.serenity.runTests;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", glue = {
		"com.test.serenity.stepDefinitions"}, tags = "@story")

public class CookieTestRunner {
}
