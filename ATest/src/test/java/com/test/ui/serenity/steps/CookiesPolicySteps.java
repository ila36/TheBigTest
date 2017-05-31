package com.test.ui.serenity.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;
import com.test.ui.pages.CookiesPolicyPage;
import com.test.ui.pages.HomePage;

import net.thucydides.core.annotations.Step;

public class CookiesPolicySteps {

	final Logger logger = LoggerFactory.getLogger("manualLogger");
	CookiesPolicyPage cookiesPolicyPage;
	HomePage homepage;

	/*
	 * @Step public void assertsOnCookiesPolicyPage() {
	 * logger.debug("Redirected me to {}",
	 * cookiesPolicyPage.getDriver().getCurrentUrl()); String
	 * cookiesPolicyPagebody =
	 * RestAssured.get(cookiesPolicyPage.getDriver().getCurrentUrl()).then().
	 * assertThat().statusCode(200) .extract().body().asString(); XmlPath
	 * xmlPath = new XmlPath(cookiesPolicyPagebody); String title =
	 * xmlPath.get(cookiesPolicyPage.getTitle()); assertThat(title,
	 * is("Cookies")); }
	 */

	@Step
	public void declineCookies() {
		cookiesPolicyPage.pushNee();
	}

}
