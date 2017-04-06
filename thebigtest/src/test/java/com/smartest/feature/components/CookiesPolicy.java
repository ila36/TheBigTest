package com.smartest.feature.components;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Cookie;

public class CookiesPolicy {

	WebDriver driver;

	public CookiesPolicy(WebDriver driver) {
		this.driver = driver;
	}

	// private static final By COOKIES_ACCEPT_BUTTON =
	// By.cssSelector("div.cc-cookies > div > p > a");
	private static final By COOKIES_ACCEPT_BUTTON = By.xpath("/html/body/div[1]/div/p/a");
	private static final By COOKIES_SPRITE_ICON_SAVED = By.cssSelector("div.cc-cookies > div > p > a > span");
	private static final By COOKIES_NOTIFICATION_TEXT = By.cssSelector("div.cc-cookies > div");
	private static final By COOKIES_DECLINE_LINK = By.cssSelector("div.cc-cookies > div > a");
	private static final By COOKIES_CONTAINER = By.cssSelector("div.cc-cookies");

	public WebElement getCookiesContainerDisabled() {
		return driver.findElement(COOKIES_CONTAINER);
	}

	public WebElement getSprite() {
		return driver.findElement(COOKIES_SPRITE_ICON_SAVED);
	}

	public WebElement getTextOfCookieButton() {
		return driver.findElement(COOKIES_ACCEPT_BUTTON);
	}

	public WebElement clickOnCookiesAcceptButton() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement cookieAcceptButton = driver.findElement(COOKIES_ACCEPT_BUTTON);
		wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton)).click();
		return driver.findElement(COOKIES_ACCEPT_BUTTON);
	}

	public WebElement getCookieNotificationText() {
		return driver.findElement(COOKIES_NOTIFICATION_TEXT);
	}

	public WebElement getHyperlinkElement() {
		return driver.findElement(COOKIES_DECLINE_LINK);
	}

	public Set<Cookie> getAllCookies() {
		return driver.manage().getCookies();
	}
}
