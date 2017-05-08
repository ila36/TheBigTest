package com.test.ui.serenity.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.test.ui.pages.CookiesPolicyPage;
import com.test.ui.pages.HomePage;

import net.thucydides.core.annotations.Step;

public class CookiesPolicySteps {

	CookiesPolicyPage cookiesPolicyPage;
	HomePage homepage;

	@Step
	public void userLandedOnCookiesPolicyPage() {
		assertThat("Cookies policy page", cookiesPolicyPage.getDriver().getCurrentUrl(),
				is("https://www.woningnetregioamsterdam.nl/cookiepolicy"));
	}
	
	@Step
	public void userpushedNoToCookies() {
		cookiesPolicyPage.pushNeeToDeclineCookies();
	}

}
