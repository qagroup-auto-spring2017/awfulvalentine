package com.valentine.AlonaPopova.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.valentine.tools.Browser;

public class VerifySearchInputFieldWithValidData {
	private WebDriver driver;
	
	@Test
	public void VerifySearchInputFieldWithValidData() {
		
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 		driver = new ChromeDriver();
		 		driver.get("http://awful-valentine.com/");
		 		
		 		driver.findElement(By.cssSelector("#searchinput")).sendKeys("Drives");
		 		
		 		driver.findElement(By.cssSelector("#searchsubmit")).click();
//		 		try {
//			 			Thread.sleep(3000);
//			 		} catch (Exception e) {
//			 	}
		
		 		WebElement searchResults = driver.findElement(By.cssSelector("#main-products > div.main-product > h4 > a"));
		 		Assert.assertEquals(searchResults.getText(), "Taking Long Drives Together", "not found");
		 		
	}
	
	@AfterClass
	 	public void tearDown() {
	 		driver.close();
	 	}

}
