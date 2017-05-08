package com.test.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.woningnetregioamsterdam.nl/cookiepolicy")
public class CookiesPolicyPage extends PageObject {

	@Managed(uniqueSession = true)

	@FindBy(css = "p:nth-child(6) > a.underline")
	private WebElement cookiesDecline;

	public CookiesPolicyPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getCookiesDecline() {
		return cookiesDecline;
	}

	public void pushNeeToDeclineCookies() {
		if (cookiesDecline.isEnabled()) {
			new WebDriverWait(getDriver(), 1).until(ExpectedConditions.elementToBeClickable(cookiesDecline)).click();
		} else {
			System.out.println("CookiesDecline link is NOT enabled");
		}
	}

}
