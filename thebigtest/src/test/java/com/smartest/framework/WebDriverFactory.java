package com.smartest.framework;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import com.gargoylesoftware.htmlunit.BrowserVersion;

public class WebDriverFactory {

	private WebDriver driver;
	private String browserName;
	private Platform platform;
	// private BrowserVersion version;

	public WebDriverFactory(String browserName, Platform platform) {

		this.browserName = browserName;
		// this.version = version;
		this.platform = platform;
	}

	/*
	 * @Parameterized.Parameters public static LinkedList<String[]>
	 * getEnvironments() throws Exception { LinkedList<String[]> env = new
	 * LinkedList<String[]>(); env.add(new String[]{Platform.WINDOWS.toString(),
	 * BrowserType.GOOGLECHROME, BrowserVersion.getDefault().toString()});
	 * env.add(new String[]{Platform.WINDOWS.toString(), BrowserType.FIREFOX
	 * ,BrowserVersion.getDefault().toString()}); //add more browsers here
	 * 
	 * return env; }
	 */

	public WebDriver setUpBrowserType() {
		//DesiredCapabilities capability;
		if (browserName.equals(BrowserType.FIREFOX)) {
			//capability = new DesiredCapabilities(browserName, null, platform);
			//capability.setCapability("platform", platform);
			//capability.setCapability("browserName", browserName);
			// capability.setCapability("version", version);
			System.setProperty("webdriver.gecko.driver", "/home/ila/testSoftware/drivers/geckodriver");
			driver = new FirefoxDriver();
		} else if (browserName.equals(BrowserType.GOOGLECHROME)) {
			//capability = new DesiredCapabilities(browserName, null, platform);
			//capability.setCapability("platform", platform);
			//capability.setCapability("browserName", browserName);
			// capability.setCapability("version", version);
			System.setProperty("webdriver.chrome.driver", "/home/ila/testSoftware/drivers/chromedriver");
			driver = new ChromeDriver();
		}
		return driver;
	}
}
