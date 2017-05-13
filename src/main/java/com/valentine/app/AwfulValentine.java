package com.valentine.app;

import org.openqa.selenium.WebDriver;

import com.valentine.tools.Browser;

public class AwfulValentine {
	
	private static WebDriver driver;

	public static HomePage openHomePage() {
		driver = Browser.open();
		driver.get("http://awful-valentine.com/");
		return new HomePage(driver);
	}
	
	public static void close() {
		if(driver != null) 
			driver.close();
		driver = null;
	}
}
