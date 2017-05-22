package com.test.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.core.annotations.findby.FindBy;
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

	public void pushThePolicyLink() {
		if ($(cookiesPolicyLink).isVisible()) {
			logger.debug("CookiesPolicylink enabled: " + $(cookiesPolicyLink).isVisible());
			new WebDriverWait(getDriver(), 2).until(ExpectedConditions.elementToBeClickable(cookiesPolicyLink)).click();
			CookiesPolicyPage cookiesPolicyPage = this.switchToPage(CookiesPolicyPage.class);
			cookiesPolicyPage.open();
			logger.debug("After push 'Meer Informatie' Redirected me to: " + cookiesPolicyPage.getDriver().getCurrentUrl());
		} else {
			logger.warn("CookiesPolicy link is NOT visible");
		}
	}

	public void pushTheCookiesButton() {
		if ($(cookiesButton).isVisible()) {
			logger.debug("CookiesButton is visible: " + $(cookiesButton).isVisible());
			new WebDriverWait(getDriver(), 2).until(ExpectedConditions.elementToBeClickable(cookiesButton)).click();
			HomePage homePage = this.switchToPage(HomePage.class);
			homePage.open();
			logger.debug("After push 'Accept cookies' Redirected me to: " + homePage.getDriver().getCurrentUrl());
		} else {
			logger.warn("CookiesButton is NOT Visible");
		}
		
	}
}