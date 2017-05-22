package com.test.ui.serenity.stepDefinitions;

import com.test.ui.serenity.steps.CookieSteps;
import com.test.ui.serenity.steps.CookiesPolicySteps;
import com.test.ui.serenity.steps.HomeSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CookiesDeclineStepDefinitions {

	@Steps
	CookieSteps cookieSteps;
	@Steps
	CookiesPolicySteps cookiesPolicySteps;
	@Steps
	HomeSteps homeSteps;
		
	@And("^I click on Meer informatie linktext$")
	public void i_click_on_Meer_informatie_linktext() throws Throwable {
		cookieSteps.userPushedThePolicyLink();
	}

	@Then("^I am on cookies policy page$")
	public void i_am_on_cookies_policy_page() throws Throwable {
		
	}
	
	@When("^I click on Nee linktext$")
	public void i_click_on_Nee_linktext() throws Throwable {
		cookiesPolicySteps.userDeclinedCookies();
	}

	@Then("^non functional cookies are declined$")
	public void non_functional_cookies_are_declined() throws Throwable {

	}

}
