package com.test.ui.serenity.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.ui.pages.CookiesPage;
import com.test.ui.pages.HomePage;
import com.test.utils.CookieFileStore;

import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

public class CookieSteps {

	final Logger logger = LoggerFactory.getLogger("manualLogger");
	CookiesPage cookiespage;
	HomePage homepage;

	@Step
	public void openHomePage() {
		homepage.open();
		logger.info("@Before:Open homepage");
	}

	@Step
	public void closeHomePage() {
		homepage.getDriver().close();
		logger.info("@After:Close homepage");
	}

	@Step
	public void userPushedThePolicyLink() {
		cookiespage.pushThePolicyLink();
		CookieFileStore.writeCookiesToFile("cookies.data", homepage);
		logger.info("Cookies accepted");
	}

	@Step
	public void acceptCookies() throws ParseException {
		cookiespage.pushTheCookiesButton();
		CookieFileStore.writeCookiesToFile("cookies.data", homepage);
		logger.info("Cookies accepted");
	}

	@Step
	public void addCookiesToBrowser() throws ParseException {
		CookieFileStore.readCookiesFromFile("cookies.data", homepage);
		logger.info("@Before:Add cookies to browser");
	}

	@Step
	public void assertCookiesPageElements() {
		logger.info("ASSERT COOKIESPAGE ELEMENTS");
		assertThat(cookiespage.getCookiesNotificationText().getText().contentEquals(
				"Wij gebruiken cookies om het gebruiksgemak van onze website te verbeteren. Klik op Accepteer cookies voor een soepel werkende website. Wilt u meer weten over cookies of wilt u het gebruik daarvan weigeren, kies dan voor Meer informatie."));
		assertThat(cookiespage.getCookiesPolicyLink().getText().equals("Meer informatie"));
		assertThat(cookiespage.getCookiesButton().getText().equals("Accepteer cookies"));
	}

	@Step
	public void assertHomePageEnabled() {
		boolean cookieIsDisplayed = false;
		try {
			cookieIsDisplayed = cookiespage.getCookiesContainer().isDisplayed();
			if (cookieIsDisplayed) {
				logger.info("Cookies page is still displayed: SOMETHING IS WRONG");
				assertThat(cookieIsDisplayed, is(false));
			}

		} catch (NoSuchElementException ex) {
			/* do nothing, cookies page is not present, assert is passed */
			logger.info("Cookies page is displayed: " + cookieIsDisplayed);
			assertThat(cookieIsDisplayed, is(false));
		}

	}

}
