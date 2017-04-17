package com.smartest.feature.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import com.smartest.feature.components.LoginButtonHome;;

public class HomePage {
	
	private WebDriver driver;
	private static final String WONINGNET_HOME_PAGE_URL = "https://www.woningnetregioamsterdam.nl/";
	private static final By BODY = By.cssSelector("body");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public static String getWoningnetHomePageUrl() {
		return WONINGNET_HOME_PAGE_URL;
	}

	public HomePage open(){
		driver.get(WONINGNET_HOME_PAGE_URL);
		return this;
	}

	public WebElement getBody() {
		return driver.findElement(BODY);
	}
	
}
