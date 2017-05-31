package com.test.ui.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.woningnetregioamsterdam.nl/Inloggen")
public class LoginPage extends PageObject {
	
	@FindBy(css = "input#gebruikersnaam")
	private WebElement gebruikersnaamTextBox;
	
	@FindBy(css = "input#password")
	private WebElement passwordTextBox;

	@FindBy(css = "input#loginButton")
	private WebElement loginButton;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getGebruikersnaamTextBox() {
		return gebruikersnaamTextBox;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public void enterGebruikersnaamAndPassword(String registrationNumber, String password) {
		gebruikersnaamTextBox.sendKeys(registrationNumber);
		passwordTextBox.sendKeys(password);
		
	}
	
	public void pushTheLoginButton() {
		if (loginButton.isEnabled()) {
			new WebDriverWait(getDriver(), 1).until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		} else {
			System.out.println("loginButton is NOT enabled");
		}
	}

}
