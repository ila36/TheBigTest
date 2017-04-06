package com.smartest.feature.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = {
		"com/smartest/feature/acceptance" }, tags = "@cookie", plugin = { "pretty",
				"html:target/cucumber-html-report/bigTest/CookieReport" })

public class CookieTestRunner {
}
