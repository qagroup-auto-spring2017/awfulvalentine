package com.valentine.AlonaPopova.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.valentine.tools.Browser;

public class VerifyAddingToTheCartFromSearchResultsList {
	private WebDriver driver;
	
	@Test
	public void VerifyAddingToTheCartFromSearchResultsList() {
		driver = new ChromeDriver();
		driver.get("http://awful-valentine.com/");
		
		driver.findElement(By.cssSelector("#searchinput")).sendKeys("Drives");
 		driver.findElement(By.cssSelector("#searchsubmit")).click();
 		driver.findElement(By.cssSelector("#main-products > div.main-product > div.et-links.clearfix > a.add-to-cart.et-shop-item")).click();
 		try {
			Thread.sleep(3000);
 		} catch (Exception e) {

	}
 		driver.findElement(By.id("addToCart_4")).click();
 		
 		WebElement yourShoppingCart = driver.findElement(By.cssSelector("#main-products > div > h1"));
 		Assert.assertEquals(yourShoppingCart.getText(), "Your Shopping Cart", "not found");
 		Assert.assertEquals(driver.getCurrentUrl(), "http://awful-valentine.com/store/cart/",
 				 			"Incorrect URL after click on 'Add to Cart' button");
 		WebElement widgetCartContent = driver.findElement(By.cssSelector("#Cart66WidgetCartEmptyAdvanced"));
 		Assert.assertEquals(widgetCartContent.getText(), "You have 1 item ($19.99) in your shopping cart.", "widget not found");
	}
	
	@AfterClass
 	public void tearDown() {
 		driver.close();
 	}

}
