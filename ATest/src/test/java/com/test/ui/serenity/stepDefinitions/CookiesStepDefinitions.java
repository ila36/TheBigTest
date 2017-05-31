package com.test.ui.serenity.stepDefinitions;

import java.text.ParseException;

import com.test.ui.serenity.steps.CookieSteps;
import com.test.ui.serenity.steps.CookiesPolicySteps;
import com.test.ui.serenity.steps.HomeSteps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CookiesStepDefinitions {

	@Steps
	HomeSteps homeSteps;
	@Steps
	CookieSteps cookieSteps;
	@Steps
	CookiesPolicySteps cookiePolicySteps;

	@Before("@addCookiesToBrowser")
	public void setUp() throws ParseException {
		cookieSteps.openHomePage();
		cookieSteps.addCookiesToBrowser();
	}

	@When("^I navigate to homepage$")
	public void i_navigate_to_homepage() throws Throwable {
		cookieSteps.openHomePage();
	}

	@Then("^I am shown a notification about cookies$")
	public void i_am_shown_a_notification_about_cookies() throws Throwable {
		cookieSteps.assertCookiesPageElements();
	}

	@When("^I accept cookies$")
	public void i_accept_cookies() throws Throwable {
		cookieSteps.acceptCookies();
	}

	@Then("^WoningNet homepage is enabled$")
	public void woningnet_homepage_is_enabled() throws Throwable {
		cookieSteps.assertHomePageEnabled();
	}

	@When("^I choose to know more about cookies policy$")
	public void i_choose_to_know_more_about_cookies_policy() throws Throwable {
		cookieSteps.userPushedThePolicyLink();
	}

	@When("^I choose to decline cookies$")
	public void i_choose_to_decline_cookies() throws Throwable {
		cookiePolicySteps.declineCookies();
	}

	@After
	public void cleanUp() throws ParseException {
		cookieSteps.closeHomePage();
	}
}
