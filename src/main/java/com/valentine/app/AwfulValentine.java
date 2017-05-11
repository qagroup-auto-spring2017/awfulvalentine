package com.valentine.app;

import org.openqa.selenium.WebDriver;

import com.valentine.tools.Browser;

public class AwfulValentine {

	public static HomePage openHomePage() {
		WebDriver driver = Browser.open();
		driver.get("http://awful-valentine.com/");
		return new HomePage(driver);
	}
}
