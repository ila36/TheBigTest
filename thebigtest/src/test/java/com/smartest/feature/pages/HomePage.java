package com.smartest.feature.pages;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.woningnetregioamsterdam.nl/")
public class HomePage extends PageObject {
	
	@Managed(uniqueSession = true)
	
	@FindBy(css = "body")
	private WebElement body;
	
	public void deleteAllNonFunctionalCookies(){
		Set<Cookie> cookies = getDriver().manage().getCookies();
		System.out.println(cookies);
		if(cookies.contains("cc_cookie_accept") || cookies.contains("cc_cookie_decline")){
				getDriver().manage().deleteCookieNamed("cc_cookie_accept");
				getDriver().manage().deleteCookieNamed("cc_cookie_decline");
		}
	}
	
	public Set<Cookie> getAllCookiesFromCurrentBrowserSession() {
		return getDriver().manage().getCookies();
	}
	
}
