package com.smartest.feature.pages;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;

public class CookiesPage extends PageObject {

	@Managed(uniqueSession = true)

	@FindBy(css = "div.cc-cookies > div")
	private WebElement cookiesNotificationText;

	@FindBy(css = "div.cc-cookies > div > a")
	private WebElement cookiesPolicyLink;

	@FindBy(css = "div.cc-cookies > div > p > a")
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
		if (cookiesButton.isEnabled()) {
			new WebDriverWait(getDriver(), 1).until(ExpectedConditions.elementToBeClickable(cookiesPolicyLink)).click();
		} else {
			System.out.println("CookiesButton is NOT enabled");
		}

	}

	public Response saveCookiesPolicyDocument() {
		Response response = RestAssured.given().get(cookiesPolicyLink.getAttribute("href")).then().extract().response();
		return response;
	}

	public Set<Cookie> acceptNonFunctionalCookies() {
		new WebDriverWait(getDriver(), 1).until(ExpectedConditions.elementToBeClickable(cookiesButton)).click();
		return getDriver().manage().getCookies();
	}
}