package com.smartest.feature.acceptance;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.smartest.feature.pages.CookiesPage;
import com.smartest.feature.pages.HomePage;
import com.smartest.framework.SharedDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CookiesPolicySteps {

	private WebDriver driver;
	private CookiesPage cookies;
	private HomePage home;

	public CookiesPolicySteps(SharedDriver driver) {
		this.driver = driver;
		cookies = new CookiesPage(driver);
		home = new HomePage(driver);
	}

	@Given("^no existance of non functional woningnet cookies in browser$")
	public void no_existance_of_non_functional_woningnet_cookies_in_browser() throws Throwable {
		Assert.assertFalse(driver.manage().getCookies().contains("cc_cookie_accept")
				&& driver.manage().getCookies().contains("cc_cookie_decline"));
	}

	@When("^user navigates to homepage$")
	public void user_navigates_to_homepage() throws Throwable {
		home.open();
		Assert.assertEquals("https://www.woningnetregioamsterdam.nl/", driver.getCurrentUrl());
		Assert.assertEquals("99999", cookies.getCookiesContainer());
	}

	@Then("^user should see a notification about cookies policy$")
	public void user_should_see_a_notification_about_cookies_policy() throws Throwable {
		Assert.assertTrue(cookies.getCookiesNotificationText().equals(
				"Wij gebruiken cookies om het gebruiksgemak van onze website te verbeteren. Klik op Accepteer cookies voor een soepel werkende website. Wilt u meer weten over cookies of wilt u cookies weigeren, kies dan voor Meer informatie.Accepteer cookies"));
	}

	@And("^user should see a link text to click on$")
	public void user_should_see_a_link_text_to_click_on() throws Throwable {
		Assert.assertTrue("Linktext for cookies policy document",
				cookies.cookiesPolicy().getCookiesPolicyLink().equals("Meer informatie"));
	}

	@And("^user should see a button to accept the cookies policy$")
	public void user_should_see_a_button_to_accept_the_cookies_policy() throws Throwable {
		Assert.assertTrue("Sprite icon exists", cookies.cookiesAcceptButton().getCookiesSpriteIconSaved()
				.equals(driver.getCurrentUrl() + "Content/Images/sprite-white.png"));
		Assert.assertTrue("Cookies button text exists",
				cookies.cookiesAcceptButton().getCookiesAcceptButton().equals("Accepteer cookies"));
	}

	@When("^user clicks on link text$")
	public void user_clicks_on_link_text() throws Throwable {
		Assert.assertEquals(200, cookies.cookiesPolicy().getResponse().getStatusCode());
	}

	@Then("^cookies policy file is downloaded$")
	public void cookies_policy_file_is_downloaded() throws Throwable {
		Assert.assertTrue("application/pdf",
				cookies.cookiesPolicy().getResponse().contentType().equals("application/pdf"));
		Assert.assertTrue("Cookiestatement 2017 ", cookies.cookiesPolicy().getResponse()
				.getHeader("Content-Disposition").contains("Cookiestatement 2017"));
	}

	@When("^user clicks on the accepteer cookies button$")
	public void user_clicks_on_the_accepteer_cookies_button() throws Throwable {
		Set<Cookie> c = cookies.cookiesAcceptButton().clickOnCookiesAcceptButton();
		for (Cookie cookie : c) {
			if (cookie.getName().equals("cc_cookie_accept") && cookie.getName().equals("cc_cookie_decline")) {
				Assert.assertTrue(
						cookie.getName().equals("cc_cookie_accept") && cookie.getValue().equals("cc_cookie_accept"));
				Assert.assertTrue(cookie.getName().equals("cc_cookie_decline") && cookie.getValue().equals(null));
			}
		}
	}

	@Then("^homepage is available")
	public void homepage_is_available() throws Throwable {
		Assert.assertTrue(home.getBody().getAttribute("class").equals("SRA_Amsterdam"));
	}

}
