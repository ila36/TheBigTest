package com.test.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.woningnetregioamsterdam.nl/cookiepolicy")
public class CookiesPolicyPage extends PageObject {

	final Logger logger = LoggerFactory.getLogger("manualLogger");

	@Managed(uniqueSession = true)

	@FindBy(css = "p:nth-child(6) > a.underline")
	private WebElement cookiesDecline;

	public CookiesPolicyPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getCookiesDecline() {
		return cookiesDecline;
	}

	public void pushNee() {
		if ($(cookiesDecline).isVisible()) {
			logger.debug("Nee hyperlink is Visible: " + $(cookiesDecline).isVisible());
			new WebDriverWait(getDriver(), 2).until(ExpectedConditions.elementToBeClickable(cookiesDecline)).click();
			HomePage homePage = this.switchToPage(HomePage.class);
			homePage.open();
			logger.debug("After push 'Nee' Redirected me to: " + homePage.getDriver().getCurrentUrl());
		} else {
			System.out.println("Nee link is NOT visible");
		}
	}

}
