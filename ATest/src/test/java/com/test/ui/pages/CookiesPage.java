package com.test.ui.pages;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.pages.PageObject;

public class CookiesPage extends PageObject {

	final Logger logger = LoggerFactory.getLogger("manualLogger");

	@FindBy(css = "div.cc-cookies")
	private WebElement cookiesContainer;

	@FindBy(css = "div.cc-cookies > div")
	private WebElement cookiesNotificationText;

	@FindBy(css = "div.cc-cookies > div > a")
	private WebElement cookiesPolicyLink;

	@FindBy(css = "div.cc-cookies > div > p > a")
	private WebElement cookiesButton;

	public WebElement getCookiesContainer() {
		return cookiesContainer;
	}

	public WebElement getCookiesNotificationText() {
		return cookiesNotificationText;
	}

	public WebElement getCookiesButton() {
		return cookiesButton;
	}

	public WebElement getCookiesPolicyLink() {
		return cookiesPolicyLink;
	}

	public void pushTheCookiesButton() throws AssertionError {
		$(cookiesButton).expect("Cookies button should be visible").shouldBeVisible();
		new WebDriverWait(getDriver(), 2).until(ExpectedConditions.elementToBeClickable(cookiesButton)).click();
		assertThat("Homepage URL: ", getDriver().getCurrentUrl(), is("https://www.woningnetregioamsterdam.nl/"));
		logger.info("After push 'Accept cookies' directed me to: " + getDriver().getCurrentUrl());
	}

	public void pushThePolicyLink() throws AssertionError {
		$(cookiesPolicyLink).expect("Meer informatie link should be visible").shouldBeVisible();
		new WebDriverWait(getDriver(), 2).until(ExpectedConditions.elementToBeClickable(cookiesPolicyLink)).click();
		waitForTitleToAppear("Cookies");
		assertThat("Cookies Policy URL: ", getDriver().getCurrentUrl(),
				is("https://www.woningnetregioamsterdam.nl/cookiepolicy"));
		logger.info("After push 'Meer Informatie' directed me to: " + getDriver().getCurrentUrl());
	}
}