package com.smartest.feature.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartest.feature.pages.LoginPage;

public class LoginButtonHome {
	
	private WebDriver driver;
	private static final By INLOGGEN_BUTTON = By.cssSelector("div.small-12.medium-5.large-5.columns.welcomeBox.hide-for-small-only > a.primary.button.wide");
    
	public LoginButtonHome(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage clickOnLoginHomeButton(){
		driver.findElement(INLOGGEN_BUTTON).click();
		return new LoginPage(driver);
	}
	
}
