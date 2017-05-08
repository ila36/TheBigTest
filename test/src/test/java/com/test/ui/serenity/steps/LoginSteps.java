package com.test.ui.serenity.steps;

import com.test.ui.pages.LoginPage;

import net.thucydides.core.annotations.Step;

public class LoginSteps {
	
	LoginPage loginpage;
	
	@Step
	public void openLoginPage(){
		loginpage.open();
	}
	
	@Step
	public void userEntersInvalidRegistrationNumberOrPassword(String registratienummer, String password){
		loginpage.enterGebruikersnaamAndPassword(registratienummer, password);
	}
	
	@Step
	public void pushTheLoginBtn(){
		loginpage.pushTheLoginButton();
	}

}
