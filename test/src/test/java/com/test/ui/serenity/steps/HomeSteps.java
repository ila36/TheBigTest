package com.test.ui.serenity.steps;

import com.test.ui.pages.CookiesPage;
import com.test.ui.pages.HomePage;
import net.thucydides.core.annotations.Step;

public class HomeSteps {

	HomePage homepage;
	CookiesPage cookiespage;
	
	@Step
	public void openHomePage(){
		homepage.open();
	}
	
	@Step
	public void closeHomePage(){
		homepage.getDriver().close();
	}
	
}
