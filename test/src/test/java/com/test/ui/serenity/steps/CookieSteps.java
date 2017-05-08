package com.test.ui.serenity.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import com.test.ui.pages.CookiesPage;
import com.test.ui.pages.HomePage;

import org.junit.Assert;
import org.junit.Ignore;
import org.openqa.selenium.Cookie;

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
		Map<String, String> cookies = RestAssured.get(homePage.getDriver().getCurrentUrl()).getCookies();
		Set<String> cookiesValues = cookies.keySet();
		for (String cookieString : cookiesValues) {
			assertThat("Non functional cookies not accepted yet", cookieString, not("cc_cookie_accept"));
			assertThat("Non functional cookies not accepted yet", cookieString, not("cc_cookie_decline"));
		}
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
	public void userPushedThePolicyLink() {
		cookiesPage.pushThePolicyLink();
	}

	@Step
	public void userPushedTheCookiesButton() {
		cookiesPage.pushTheCookiesButton();
	}
	
}
