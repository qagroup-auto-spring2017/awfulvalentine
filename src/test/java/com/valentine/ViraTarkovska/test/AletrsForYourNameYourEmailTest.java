package com.valentine.ViraTarkovska.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class AletrsForYourNameYourEmailTest {
	private WebDriver driver;

	@Test
	public void testAletrsForYourNameYourEmail() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://awful-valentine.com/contact-us/");

		driver.findElement(By.cssSelector("input[value='Send']")).click();
		WebElement alertYourName = driver.findElement(By.cssSelector("span[class*='your-name']"));
		Thread.sleep(1000);
		Assert.assertEquals(alertYourName.getText(), "Please fill the required field.", "YourName alert text was checked: ");

		WebElement alertYourEmail = driver.findElement(By.cssSelector("span[class*='your-email']"));
		Assert.assertEquals(alertYourEmail.getText(), "Please fill the required field.", "YourEmail alert text was checked: ");

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
