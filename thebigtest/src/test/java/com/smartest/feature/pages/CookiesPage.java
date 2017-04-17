package com.smartest.feature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.smartest.feature.components.CookiesAcceptButton;
import com.smartest.feature.components.CookiesPolicy;

public class CookiesPage {

	WebDriver driver;
	private CookiesAcceptButton cookiesAcceptButton;
	private CookiesPolicy cookiesPolicy;
	private static final By COOKIES_NOTIFICATION_TEXT = By.cssSelector("div.cc-cookies > div");
	private static final By COOKIES_CONTAINER = By.cssSelector("div.cc-cookies");
	
	public CookiesPage(WebDriver driver) {
		this.cookiesPolicy = new CookiesPolicy(driver);
		this.cookiesAcceptButton = new CookiesAcceptButton(driver);
		this.driver = driver;
	}
	
	public WebElement getCookiesContainer() {
		return driver.findElement(COOKIES_CONTAINER);
	}
	
	public WebElement getCookiesNotificationText() {
		return driver.findElement(COOKIES_NOTIFICATION_TEXT);
	}
	
	public CookiesPolicy cookiesPolicy(){
		return cookiesPolicy;
	}
	
	public CookiesAcceptButton cookiesAcceptButton(){
		return cookiesAcceptButton;
	}

}
