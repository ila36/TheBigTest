package com.test.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.woningnetregioamsterdam.nl/")
public class HomePage extends PageObject {

	@FindBy(css = "body")
	private WebElement body;

	public WebElement getBody() {
		return body;
	}

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
}
