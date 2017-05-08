package com.test.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;

public class CookiesPage extends PageObject {

	@FindBy(css = "div.cc-cookies > div")
	private WebElement cookiesNotificationText;

	@FindBy(css = "div.cc-cookies > div > a")
	private WebElement cookiesPolicyLink;

	@FindBy(css = "div.cc-cookies > div > a")
	private WebElement cookiesButton;

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
		if ($(cookiesPolicyLink).isEnabled()) {
			System.out.println("CookiesPolicylink clicked" + cookiesPolicyLink.isEnabled());
			new WebDriverWait(getDriver(), 1).until(ExpectedConditions.elementToBeClickable(cookiesPolicyLink)).click();
		} else {
			System.out.println("CookiesPolicy link is NOT enabled");
		}

	}

	public void pushTheCookiesButton() {
		if (cookiesButton.isEnabled()) {
			new WebDriverWait(getDriver(), 1).until(ExpectedConditions.elementToBeClickable(cookiesButton)).click();
		} else {
			System.out.println("CookiesButton is NOT enabled");
		}
	}

}