package com.test.ui.serenity.stepDefinitions;

import com.test.ui.serenity.steps.CookieSteps;
import com.test.ui.serenity.steps.CookiesPolicySteps;
import com.test.ui.serenity.steps.HomeSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CookiesNotificationStepDefinitions {

	@Steps
	CookieSteps cookieSteps;
	@Steps
	CookiesPolicySteps cookiesPolicySteps;
	@Steps
	HomeSteps homeSteps;
	
	@Given("^I am on WoningNet homepage$")
	public void i_am_on_WoningNet_homepage() throws Throwable {
		cookieSteps.openHomePage();
	}

	@Given("^I see a cookies notification$")
	public void i_see_a_cookies_notification() throws Throwable {
		cookieSteps.userHasToBeInformedAboutCookiesPolicy();
	}

	@Then("^I should see a notification text$")
	public void i_should_see_a_notification_text(String arg1) throws Throwable {
		cookieSteps.cookiesNotificationTextIsAvailable(arg1);
	}

	@Then("^I should see a linktext for navigation to the cookies policy document$")
	public void i_should_see_a_linktext_for_navigation_to_the_cookies_policy_document() throws Throwable {
		cookieSteps.cookiesLinkToOpenCookiesPolicyDocumentIsAvailable();
	}

	@Then("^I should see a button for acceptance of non functional cookies$")
	public void i_should_see_a_button_for_acceptance_of_non_functional_cookies() throws Throwable {
		cookieSteps.cookiesAcceptButtonIsAvailable();
	}
}
