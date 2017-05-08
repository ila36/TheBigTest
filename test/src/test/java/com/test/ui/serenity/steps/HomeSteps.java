package com.test.ui.serenity.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.xml.XmlPath;
import com.test.ui.pages.HomePage;
import net.thucydides.core.annotations.Step;

public class HomeSteps {

	HomePage homepage;
	
	@Step
	public void userLandedBackToHomePage() {
		assertThat("Back to HomePage", homepage.getDriver().getCurrentUrl(),
				is("https://www.woningnetregioamsterdam.nl/"));
	}

	@Step
	public void homePageEnabled() {
		
		String body = RestAssured.get(homepage.getDriver().getCurrentUrl()).then().assertThat().statusCode(200)
				.extract().body().asString();
		XmlPath xmlPath = new XmlPath(body).setRoot("body");
		String homePageRegioAmsterdam = xmlPath.get(homepage.getBody().getAttribute("class"));
		RestAssured.expect().body(homePageRegioAmsterdam, is("SRA_Amsterdam")).when()
				.get(homepage.getDriver().getCurrentUrl());
	}

}
