package com.test.ui.pages;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
		$(cookiesDecline).expect("Nee link to decline should be visible").shouldBeVisible();
			new WebDriverWait(getDriver(), 2).until(ExpectedConditions.elementToBeClickable(cookiesDecline)).click();
			assertThat("Go back to Homepage URL: ", getDriver().getCurrentUrl(), is("https://www.woningnetregioamsterdam.nl/"));
			logger.debug("After push 'Nee' directed me to: " + getDriver().getCurrentUrl());
		
	}

}
