package com.smartest.feature.components;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookiesAcceptButton {

	private WebDriver driver;
	private static final By COOKIES_ACCEPT_BUTTON = By.xpath("/html/body/div[1]/div/p/a");
	private static final By COOKIES_SPRITE_ICON_SAVED = By.cssSelector("body > div.cc-cookies > div > p > a > span");

	public CookiesAcceptButton(WebDriver driver) {
		this.driver = driver;
	}

	public String getCookiesAcceptButton() {
		return driver.findElement(COOKIES_ACCEPT_BUTTON).getText();
	}

	public String getCookiesSpriteIconSaved() {
		return driver.findElement(COOKIES_SPRITE_ICON_SAVED).getCssValue("background-image").replaceAll("url\\(\"", "")
				.replaceAll("\"\\)", "");
	}

	public Set<Cookie> clickOnCookiesAcceptButton() {
		if (driver.findElement(COOKIES_ACCEPT_BUTTON).isDisplayed()) {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement cookieAcceptButton = driver.findElement(COOKIES_ACCEPT_BUTTON);
			wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton)).click();
		} else {
			System.out.println(
					"Button Accepteer Cookies NOT displayed:" + driver.findElement(COOKIES_ACCEPT_BUTTON).getText());
		}
		return driver.manage().getCookies();
	}

}