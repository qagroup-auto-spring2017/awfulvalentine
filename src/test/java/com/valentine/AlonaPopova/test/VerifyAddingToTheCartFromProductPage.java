package com.valentine.AlonaPopova.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.valentine.tools.Browser;

public class VerifyAddingToTheCartFromProductPage {
	private WebDriver driver;

	@Test
	public void VerifyAddingToTheCartFromProductPage() {
		
			driver = new ChromeDriver();
	 		driver.get("http://awful-valentine.com/");
	 		driver.findElement(By.cssSelector("#special-items > div:nth-child(1) > div.et-links.clearfix > a.more-info")).click();
	 		driver.findElement(By.cssSelector("#main-products > div.entry.post.clearfix > div.item-description > a")).click();
	 		
	 		try {
				Thread.sleep(3000);
	 		} catch (Exception e) {

		}
	 		driver.findElement(By.cssSelector("#addToCart_6")).click();
	 		
	 		try {
				Thread.sleep(3000);
	 		} catch (Exception e) {

		}
	 		WebElement yourShoppingCart = driver.findElement(By.cssSelector("#main-products > div > h1"));
	 		Assert.assertEquals(yourShoppingCart.getText(), "Your Shopping Cart", "not found");
	 		Assert.assertEquals(driver.getCurrentUrl(), "http://awful-valentine.com/store/cart/",
	 				 			"Incorrect URL after click on 'Add to Cart' button");
		}

	@AfterClass
 	public void tearDown() {
 		driver.close();
}
}