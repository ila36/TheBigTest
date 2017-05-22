package com.test.ui.serenity.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.ui.pages.CookiesPage;

import net.thucydides.core.annotations.Step;

public class CookieSteps {

	final Logger logger = LoggerFactory.getLogger("manualLogger");
	CookiesPage cookiesPage;

	@Step
	private Set<Cookie> getCookies() {
		Set<Cookie> allCookies = cookiesPage.getDriver().manage().getCookies();
		return allCookies;
	}

	@Step
	public void userPushedTheCookiesButton() {
		cookiesPage.pushTheCookiesButton();
		Set<Cookie> allCookies = getCookies();
		for (Cookie c : allCookies) {
			if (c.getName().equals("cc_cookie_accept")) {
				assertThat("non functional cookies accepted", c.getValue(), is("cc_cookie_accept"));
				logger.debug("NON FUNCTIONAL COOKIES ACCEPTED AND SET IN BROWSER CACHE");
			} else if (c.getName().equals("cc_cookie_decline")) {
				assertThat("Cookies decline set to NULL", c.getValue(), is("null"));
				logger.debug("COOKIE DECLINE set to null value");
			}
		}
		/*
		 * RestAssured.get(cookiesPage.getDriver().getCurrentUrl()).then().
		 * assertThat().cookies("cc_cookie_accept", "cc_cookie_accept",
		 * "cc_cookie_decline", null);
		 */
	}

	@Step
	public void userPushedThePolicyLink() {
		cookiesPage.pushThePolicyLink();
		Set<Cookie> allCookies = getCookies();
		for (Cookie c : allCookies) {
			if (c.getName().equals("cc_cookie_accept")) {
				assertThat("cc_cookie_accept set to null value", c.getValue(), is("null"));
				logger.debug("NON FUNCTIONAL COOKIES DECLINED AND SET IN BROWSER CACHE AS null value");
			} else if (c.getName().equals("cc_cookie_decline")) {
				assertThat("non functional cookies declined", c.getValue(), is("cc_cookie_decline"));
				logger.debug("COOKIES DECLINED");
			}
		}
		/*
		 * RestAssured.get(cookiesPage.getDriver().getCurrentUrl()).then().
		 * assertThat().cookies("cc_cookie_accept", null, "cc_cookie_decline",
		 * "cc_cookie_decline");
		 */
	}

	@Step
	public void assertCookiesPageElements() {
		logger.info("ASSERT COOKIESPAGE ELEMENTS");
		assertThat(cookiesPage.getCookiesNotificationText().getText().contentEquals(
				"Wij gebruiken cookies om het gebruiksgemak van onze website te verbeteren. Klik op Accepteer cookies voor een soepel werkende website. Wilt u meer weten over cookies of wilt u het gebruik daarvan weigeren, kies dan voor Meer informatie."));
		assertThat(cookiesPage.getCookiesPolicyLink().getText().equals("Meer informatie"));
		assertThat(cookiesPage.getCookiesButton().getText().equals("Accepteer cookies"));
	}

	@Step
	public void assertHomePageEnabled() {
		logger.info("ASSERT HOMEPAGE ENABLED");
		boolean cookieIsDisplayed = false;
		try {
			cookieIsDisplayed = cookiesPage.getCookiesContainer().isDisplayed();
			if (cookieIsDisplayed) {
				logger.info("Cookies page is still displayed: SOMETHING IS WRONG");
				assertThat(false);
			}

		} catch (NoSuchElementException ex) {
			/* do nothing, link is not present, assert is passed */
			logger.info("Cookie page is displayed " + cookieIsDisplayed);
			assertThat(cookieIsDisplayed, is(false));
		}

	}

}
