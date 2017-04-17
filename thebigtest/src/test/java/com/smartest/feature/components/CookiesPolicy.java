package com.smartest.feature.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CookiesPolicy {

	private WebDriver driver;
	private static final By COOKIES_POLICY_LINK = By.linkText("Meer informatie");
	private String linkToCheck;
	private Response response;
	
	public CookiesPolicy(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCookiesPolicyLink() {
		return driver.findElement(COOKIES_POLICY_LINK);
	}

	public Response checkStatusCodeOk200() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement linkText = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(COOKIES_POLICY_LINK)));
		linkText.click();
		if (linkText.isDisplayed()) {
			linkToCheck = driver.findElement(COOKIES_POLICY_LINK).getAttribute("href");
			response = given().get(linkToCheck).then().extract().response();
		} else {
			System.out.println("Expected link text NOT displayed:" + driver.findElement(COOKIES_POLICY_LINK).getText());
		}
		return response;

	}
	
}
