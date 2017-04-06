package com.smartest.feature.pages;

import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private static final String WONINGNET_LOGIN_PAGE_URL = "https://www.woningnetregioamsterdam.nl/Inloggen";
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public LoginPage open(){
		driver.get(WONINGNET_LOGIN_PAGE_URL);
		return this;
	}

}
