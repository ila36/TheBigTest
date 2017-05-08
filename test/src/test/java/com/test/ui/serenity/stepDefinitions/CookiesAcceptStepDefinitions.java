package com.test.ui.serenity.stepDefinitions;

import com.test.ui.serenity.steps.CookieSteps;
import com.test.ui.serenity.steps.HomeSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CookiesAcceptStepDefinitions {

	@Steps
	CookieSteps cookieSteps;
	@Steps
	HomeSteps homeSteps;
	
	@When("^I click on the button Accepteer cookies$")
	public void i_click_on_the_button_Accepteer_cookies() throws Throwable {
		cookieSteps.userPushedTheCookiesButton();
	}
	
	@And("^non functional cookies are accepted$")
	public void non_functional_cookies_are_accepted() throws Throwable {

	}
	
}
