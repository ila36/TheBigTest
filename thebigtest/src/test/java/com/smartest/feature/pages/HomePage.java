package com.smartest.feature.pages;


import org.openqa.selenium.WebDriver;
import com.smartest.feature.components.CookiesPolicy;
//import com.smartest.feature.components.LoginButtonHome;;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.cookiesPolicy = new CookiesPolicy(driver);
		this.driver = driver;
	}
	
	private static final String WONINGNET_HOME_PAGE_URL = "https://www.woningnetregioamsterdam.nl/";
	//private final LoginButtonHome loginButtonHome;
	private CookiesPolicy cookiesPolicy;
	
	public HomePage open(){
		driver.get(WONINGNET_HOME_PAGE_URL);
		return this;
	}
	
	/*public LoginButtonHome loginButtonHome(){
		return loginButtonHome; 
	}
	*/
	
	public CookiesPolicy cookiesPolicy(){
		return cookiesPolicy;
	}
	
	

}
