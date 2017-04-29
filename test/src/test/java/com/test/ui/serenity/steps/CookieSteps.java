package com.test.ui.serenity.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.jayway.restassured.response.Response;
import com.test.ui.pages.CookiesPage;
import com.test.ui.pages.HomePage;

import org.junit.Assert;
import net.thucydides.core.annotations.Step;

public class CookieSteps {

	HomePage homePage;
	CookiesPage cookiesPage;

	@Step
	public void openHomePage() {
		homePage.open();
	}

	@Step
	public void userHasToBeInformedAboutCookiesPolicy() {
		homePage.deleteAllNonFunctionalCookies();
	}

	@Step
	public void cookiesNotificationTextIsAvailable(String notificationtext) {
		assertThat(cookiesPage.getCookiesNotificationText().getText().equals(notificationtext));
	}

	@Step
	public void cookiesLinkToOpenCookiesPolicyDocumentIsAvailable() {
		assertThat(cookiesPage.getCookiesPolicyLink().getText().equals("Meer informatie"));
	}

	@Step
	public void cookiesAcceptButtonIsAvailable() {
		assertThat(cookiesPage.getCookiesButton().getText().equals("Accepteer cookies"));
		assertThat(cookiesPage.getCookiesButton().isEnabled());
	}
	
	@Step
	public void userPushedThePolicyLink(){
		cookiesPage.pushThePolicyLink();
	}
	
	@Step
	public void cookiesPolicyDocumentSavedAsPdf(){
		Response response = cookiesPage.saveCookiesPolicyDocument();
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertEquals("application/pdf", response.getContentType());
		Assert.assertTrue(response.getHeader("Content-Disposition").contains("Cookiestatement 2017"));
	}
}
