package com.valentine.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	public static WebDriver open() {
		//System.setProperty("webdriver.chrome.driver", "E:\\lib\\chromedriver_win32\\chromedriver.exe");
		return new ChromeDriver();
	}
}
