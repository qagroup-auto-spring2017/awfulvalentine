package com.valentine.AlonaPopova.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.valentine.tools.Browser;

public class VerifyMoreInfoButtonOfTheProductFromSpecialOffersList {
	private WebDriver driver;

	@Test
	public void VerifyMoreInfoButtonOfTheProductFromSpecialOffersList() {
		driver = new ChromeDriver();
 		driver.get("http://awful-valentine.com/");
 		driver.findElement(By.cssSelector("#special-items > div:nth-child(1) > div.et-links.clearfix > a.more-info")).click();
 		
 		Assert.assertEquals(driver.getCurrentUrl(), "http://awful-valentine.com/closeness-and-togetherness/",
		 			"Incorrect URL after click on 'Closeness and Togetherness --> More info' button");
 		
 		WebElement productPageClosenessAndTogetherness = driver.findElement(By.cssSelector("#breadcrumbs"));
 		Assert.assertEquals(productPageClosenessAndTogetherness.getText(), "Home » Uncategorized » Closeness and Togetherness", "Product page 'Closeness and Togetherness' not found");

}
	@AfterClass
 	public void tearDown() {
 		driver.close();
}
}
