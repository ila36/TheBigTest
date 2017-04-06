package com.smartest.feature.acceptance;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import com.smartest.feature.pages.HomePage;
import com.smartest.framework.SharedDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CookiesPolicySteps {

	private WebDriver driver;
	private HomePage home;

	public CookiesPolicySteps(SharedDriver driver) {
		this.driver = driver;
		home = new HomePage(driver);
	}

	@Given("^user navigates to homepage$")
	public void user_navigates_to_homepage() throws Throwable {
		home.open();
		Assert.assertEquals("https://www.woningnetregioamsterdam.nl/", driver.getCurrentUrl());
		Assert.assertEquals("99999", home.cookiesPolicy().getCookiesContainerDisabled().getCssValue("z-index"));
	}

	@And("^cookies not present in current browser$")
	public void cookies_not_present_in_current_browser() throws Throwable {
		Assert.assertFalse(home.cookiesPolicy().getAllCookies().contains("cc_cookie_accept")
				&& home.cookiesPolicy().getAllCookies().contains("cc_cookie_decline"));
	}

	@Then("^user should see a notification about cookies policy$")
	public void user_should_see_a_notification_about_cookies_policy() throws Throwable {
		Assert.assertEquals("Notification container blok", "cc-cookies-container",
				home.cookiesPolicy().getCookieNotificationText().getAttribute("class"));
		Assert.assertTrue(home.cookiesPolicy().getCookieNotificationText().getText().contains(
				"Wij gebruiken cookies om het gebruiksgemak van onze website te verbeteren. Klik op Accepteer cookies voor een soepel werkende website. Wilt u meer weten over cookies of wilt u cookies weigeren, kies dan voor"));
	}

	@And("^user should see a hyperlink to decline the cookies policy$")
	public void user_should_see_a_hyperlink_to_decline_the_cookies_policy() throws Throwable {
		Assert.assertEquals("Linktext for declining cookies", "Meer informatie",
				home.cookiesPolicy().getHyperlinkElement().getText());
		Assert.assertEquals("Hyperlink for declining exists",
				"https://www.woningnetregioamsterdam.nl/cookiepolicy#decline",
				home.cookiesPolicy().getHyperlinkElement().getAttribute("href"));
	}

	@And("^user should see a button to accept the cookies policy$")
	public void user_should_see_a_button_to_accept_the_cookies_policy() throws Throwable {
		Assert.assertEquals("Sprite icon exists", "sprite-white icon saved",
				home.cookiesPolicy().getSprite().getAttribute("class"));
		Assert.assertEquals("Cookies button text exists", "Accepteer cookies",
				home.cookiesPolicy().getTextOfCookieButton().getText());
	}

	@Given("^cookies policy presented$")
	public void cookies_policy_presented() throws Throwable {
		Assert.assertEquals("99999", home.cookiesPolicy().getCookiesContainerDisabled().getCssValue("z-index"));
	}

	@When("^user clicks on the accepteer cookies button$")
	public void user_clicks_on_the_accepteer_cookies_button() throws Throwable {
		Assert.assertEquals("Accepteer cookies", "https://www.woningnetregioamsterdam.nl/#accept",
				home.cookiesPolicy().clickOnCookiesAcceptButton().getAttribute("href"));

	}

	@Then("^cookies present in current browser$")
	public void cookies_present_in_current_browser() throws Throwable {
		Set<Cookie> c = home.cookiesPolicy().getAllCookies();
		for (Cookie cookie : c) {
			if (cookie.getName().equals("cc_cookie_accept") && cookie.getName().equals("cc_cookie_decline")) {
				System.out.println("****************************************************"+ c);
				Assert.assertTrue(cookie.getName().equals("cc_cookie_accept") && cookie.getValue().equals("cc_cookie_accept"));
				Assert.assertTrue(cookie.getName().equals("cc_cookie_decline") && cookie.getValue().equals(null));
			}
		}

	}

}
