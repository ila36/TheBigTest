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

	@Given("^user navigates to homepage$")
	public void user_navigates_to_homepage() throws Throwable {
		home.open();
		Assert.assertEquals("https://www.woningnetregioamsterdam.nl/", driver.getCurrentUrl());
		Assert.assertEquals("99999", cookies.getCookiesContainer().getCssValue("z-index"));
	}

	@And("^cookies not present in current browser$")
	public void cookies_not_present_in_current_browser() throws Throwable {
		Assert.assertFalse(driver.manage().getCookies().contains("cc_cookie_accept")
				&& driver.manage().getCookies().contains("cc_cookie_decline"));
	}

	@Then("^user should see a notification about cookies policy$")
	public void user_should_see_a_notification_about_cookies_policy() throws Throwable {
		Assert.assertEquals("Notification container blok", "cc-cookies-container",
				cookies.getCookiesNotificationText().getAttribute("class"));
		Assert.assertTrue(cookies.getCookiesNotificationText().getText().contains(
				"Wij gebruiken cookies om het gebruiksgemak van onze website te verbeteren. Klik op Accepteer cookies voor een soepel werkende website. Wilt u meer weten over cookies of wilt u cookies weigeren, kies dan voor"));
	}

	@And("^user should see a link text to click on$")
	public void user_should_see_a_link_text_to_click_on() throws Throwable {
		Assert.assertEquals("Linktext for cookies policy document", "Meer informatie",
				cookies.cookiesPolicy().getCookiesPolicyLink().getText());
	}

	@And("^user should see a button to accept the cookies policy$")
	public void user_should_see_a_button_to_accept_the_cookies_policy() throws Throwable {
		Assert.assertEquals("Sprite icon exists", "sprite-white icon saved",
				cookies.cookiesAcceptButton().getCookiesSpriteIconSaved().getAttribute("class"));
		Assert.assertEquals("Cookies button text exists", "Accepteer cookies",
				cookies.cookiesAcceptButton().getCookiesAcceptButton().getText());
	}

	@When("^user clicks on link text$")
	public void user_clicks_on_link_text() throws Throwable {
		Assert.assertEquals(200, cookies.cookiesPolicy().checkStatusCodeOk200().getStatusCode());
	}

	@Then("^cookies policy file is downloaded$")
	public void cookies_policy_file_is_downloaded() throws Throwable {
		Assert.assertEquals("application/pdf", cookies.cookiesPolicy().checkStatusCodeOk200().contentType());
		Assert.assertTrue("Cookiestatement 2017 ", cookies.cookiesPolicy().checkStatusCodeOk200()
				.getHeader("Content-Disposition").contains("Cookiestatement 2017"));
	}

	@When("^user clicks on the accepteer cookies button$")
	public void user_clicks_on_the_accepteer_cookies_button() throws Throwable {
		Set<Cookie> c = cookies.cookiesAcceptButton().clickOnCookiesAcceptButton();
		for (Cookie cookie : c) {
			if (cookie.getName().equals("cc_cookie_accept") && cookie.getName().equals("cc_cookie_decline")) {
				System.out.println("****************************************************" + c);
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
