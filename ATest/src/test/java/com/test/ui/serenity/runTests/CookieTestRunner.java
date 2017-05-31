package com.test.ui.serenity.runTests;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", glue = {
		"com.test.ui.serenity.stepDefinitions"}, tags = "@cookies")

public class CookieTestRunner {
}
