package com.test.ui.serenity.stepDefinitions;

import com.test.ui.serenity.steps.CookieSteps;
import com.test.ui.serenity.steps.HomeSteps;
import com.test.ui.serenity.steps.LoginSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginStepDefinitions {
	
	@Steps
	HomeSteps homesteps;
	@Steps
	CookieSteps cookiesteps;
	@Steps
	LoginSteps loginsteps;
	
	@Given("^I was on homepage$")
	public void i_was_on_homepage() throws Throwable {
	   
	}
	
	@Given("^I accepted cookies$")
	public void i_accepted_cookies() throws Throwable {
	   
	}

	@Given("^I entered incorrect \"([^\"]*)\" registratienummer \"([^\"]*)\" password$")
	public void i_entered_incorrect_registratienummer_password(String arg1, String arg2) throws Throwable {
		loginsteps.openLoginPage();
		loginsteps.userEntersInvalidRegistrationNumberOrPassword(arg1, arg2);
	}

	@When("^I submit for login$")
	public void i_submit_for_login() throws Throwable {
		loginsteps.pushTheLoginBtn();
	}

	@Then("^I should get a validation error$")
	public void i_should_get_a_validation_error() throws Throwable {

	}

}
