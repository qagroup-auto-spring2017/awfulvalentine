package com.valentine.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class AddItemToCartTest {
	private WebDriver driver;

	@Test
	public void testTheAddCartButtonOpensPopup() {
		System.setProperty("webdriver.chrome.driver", "E:\\lib\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://awful-valentine.com/");

		driver.findElement(By.cssSelector("[href='#et-offer-post-30']")).click();
		WebElement addToCartPopup = driver.findElement(By.id("fancybox-wrap"));

		Assert.assertTrue(addToCartPopup.isDisplayed(), "'Add to cart' Popup did not appear.");

		waitFor(1000);
		WebElement title = driver.findElement(By.cssSelector("#et-offer-post-30 .et_popup_title"));
		Assert.assertEquals(title.getText(), "Closeness and Togetherness", "Incorrect product title");
	}

	@Test(dependsOnMethods = "testTheAddCartButtonOpensPopup")
	public void testAddToCartButtonOnPopupRedirectsToCartPage() {
		waitFor(3000);
		driver.findElement(By.id("addToCart_6_2")).click();

		Assert.assertEquals(driver.getCurrentUrl(), "http://awful-valentine.com/store/cart/",
				"Incorrect URL after click on 'Add to Cart' button");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	private void waitFor(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
