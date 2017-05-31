package com.valentine.app;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.valentine.tools.App;
import com.valentine.tools.Browser;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class AwfulValentine implements App {

	private static final String BASE_URL = "http://awful-valentine.com/";

	private WebDriver driver;

	@Step("Open Home Page by URL: " + BASE_URL)
	public HomePage openHomePage() {
		driver = Browser.open();
		if (!"android".equals(System.getProperty("browser"))) {
			driver.manage().window().maximize();
		}
		driver.get(BASE_URL);
		return new HomePage(driver);
	}

	@Step("Close Browser")
	public void close() {
		if (driver != null)
			driver.quit();
		driver = null;
	}

	@Attachment("Screenshot")
	public byte[] takeScreenshot() {
		TakesScreenshot takesScreenshot = TakesScreenshot.class.cast(driver);
		return takesScreenshot.getScreenshotAs(OutputType.BYTES);
	}
}
