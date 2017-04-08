package com.smartest.framework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;


public class WebDriverFactory {

	private WebDriver driver;
	
	public WebDriverFactory() {
		
	}

	public WebDriver setBrowserChoicesFromJenkins() {
		//DesiredCapabilities capability;
		
		System.out.println("*************************************************"+ System.getProperty("browserName"));
		if (System.getProperty("browserName").equals("firefox")) {
			//capability = new DesiredCapabilities(browserName, null, platform);
			//capability.setCapability("platform", platform);
			//capability.setCapability("browserName", browserName);
			// capability.setCapability("version", version);
			System.setProperty("webdriver.gecko.driver", "/home/ila/testSoftware/drivers/geckodriver");
			driver = new FirefoxDriver();
		} else if (System.getProperty("browserName").equals("chrome")) {
			//capability = new DesiredCapabilities(browserName, null, platform);
			//capability.setCapability("platform", platform);
			//capability.setCapability("browserName", browserName);
			// capability.setCapability("version", version);
			System.setProperty("webdriver.chrome.driver", "/home/ila/testSoftware/drivers/chromedriver");
			driver = new ChromeDriver();
		}
		else if (System.getProperty("browserName").equals("opera")) {
			OperaOptions chromeOptions = new OperaOptions();
			chromeOptions.setBinary("/usr/bin/opera");
			System.setProperty("webdriver.opera.driver", "/home/ila/testSoftware/drivers/operadriver");
			driver = new OperaDriver();
		}
		return driver;
	}
}
