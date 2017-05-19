package com.valentine.app;

import org.openqa.selenium.WebDriver;

import com.valentine.tools.Browser;

import ru.yandex.qatools.allure.annotations.Step;

public class AwfulValentine {
	
	private static final String BASE_URL = "http://awful-valentine.com/";
	private static final String CONTACT_US_URL = "http://awful-valentine.com/contact-us/";
	
	private static WebDriver driver;

	@Step("Open Home Page by URL: " + BASE_URL)
	public static HomePage openHomePage() {
		driver = Browser.open();
		driver.manage().window().maximize();
		driver.get(BASE_URL);
		return new HomePage(driver);
	}
	
	@Step("Open ContactUS Page by URL: " + CONTACT_US_URL)
	public static ContactUsPage openContactUsPage() {
		driver = Browser.open();
		driver.manage().window().maximize();
		driver.get(CONTACT_US_URL);
		return new ContactUsPage(driver);
	}
	
	
	@Step("Close Browser")
	public static void close() {
		if(driver != null) 
			driver.close();
		driver = null;
	}
}
