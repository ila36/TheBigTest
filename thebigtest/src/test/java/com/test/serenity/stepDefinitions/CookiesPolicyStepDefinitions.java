package com.test.serenity.stepDefinitions;

import com.test.serenity.steps.CookieSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CookiesPolicyStepDefinitions {
	
	@Steps
	CookieSteps cookieSteps;

	@Given("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable {
		cookieSteps.openHomePage();
	}

	@Given("^user did not accept non-functional cookies$")
	public void user_did_not_accept_non_functional_cookies() throws Throwable {
	    cookieSteps.userHasToBeInformedAboutCookiesPolicy();
	}
	
	@And("^user should see a notification text$")
	public void user_should_see_a_notification_text(String arg1) throws Throwable {
		cookieSteps.cookiesNotificationTextIsAvailable(arg1);
	}

	@And("^user is shown a linktext for navigation to the cookies policy document$")
	public void user_is_shown_a_linktext_for_navigation_to_the_cookies_policy_document() throws Throwable {
		cookieSteps.cookiesLinkToOpenCookiesPolicyDocumentIsAvailable();
	}

	@And("^user is shown a button for acceptance of the non-functional cookies$")
	public void user_is_shown_a_button_for_acceptance_of_the_non_functional_cookies() throws Throwable {
		cookieSteps.cookiesAcceptButtonIsAvailable();
	}

	@When("^user clicks on linktext Meer informatie$")
	public void user_clicks_on_linktext_Meer_informatie() throws Throwable {
	     cookieSteps.userPushedThePolicyLink();
	}

	@Then("^cookies policy file is downloaded$")
	public void cookies_policy_file_is_downloaded() throws Throwable {
		cookieSteps.cookiesPolicyDocumentSavedAsPdf();	
	}

	@When("^user clicks on the button Accepteer cookies$")
	public void user_clicks_on_the_button_Accepteer_cookies() throws Throwable {

	}

	@Then("^WoningNet website functionality is available")
	public void WoningNet_website_functionality_is_available() throws Throwable {

	}

}
