package com.valentine.tools;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Browser {

	public static WebDriver open() {
		String browserName = System.getProperty("browser");

		if (browserName == null || "chrome".equals(browserName))
			return startChromeDriver();
		else if ("firefox".equals(browserName))
			return startFirefoxDriver();
		else if ("safari".equals(browserName))
			return startSafariDriver();
		else if ("android".equals(browserName))
			return startChromeOnAndroid();

		throw new RuntimeException("Unsupported browser: " + browserName);
	}

	private static WebDriver startSafariDriver() {
		return new SafariDriver();
	}

	private static WebDriver startChromeDriver() {
		return new ChromeDriver();
	}

	private static WebDriver startFirefoxDriver() {
		return new FirefoxDriver();
	}

	private static WebDriver startChromeOnAndroid() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy A3");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.BROWSER);
		capabilities.setCapability(AndroidMobileCapabilityType.AVD, "Nexus_api_21");
		AndroidDriver<WebElement> driver = null;
		try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Couldn't start android driver: malformed URL", e);
		}
		return driver;
	}

}
