package com.valentine.ViraTarkovska.test;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
/*import org.openqa.selenium.chrome.ChromeDriver;*/
//import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.valentine.app.AwfulValentine;
import com.valentine.app.HomePage;
//import com.valentine.tools.Browser;
import static org.testng.Assert.*;

public class PurchaseFormsPurchButton_DropTest {
//			private WebDriver driver;
			private HomePage onHomePage;
			
	@Test
	public void testPurchaseFormsPurchaseButton() throws InterruptedException {
		/*System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();*/
		/*driver = Browser.open();
		driver.get("http://awful-valentine.com/");*/
		onHomePage = AwfulValentine.openHomePage();
		
		
		//Hover
//		Actions actions = new Actions(driver);
//		WebElement mainMenuPurchaseForms = driver.findElement(By.cssSelector("#top-menu>li:nth-child(4)"));
//		actions.moveToElement(mainMenuPurchaseForms);
//
//		WebElement thirdPartyLinks = driver.findElement(By.cssSelector("#top-menu>li:nth-child(4) li:nth-child(1)"));
//		actions.moveToElement(thirdPartyLinks);
//		actions.click().build().perform();
		
		//Hover Second version
//		Actions action = new Actions(driver);
//		WebElement mainMenuPurchaseForms = driver.findElement(By.cssSelector("#top-menu>li:nth-child(4)"));
//		action.moveToElement(mainMenuPurchaseForms).moveToElement(driver.findElement(By.cssSelector("#top-menu>li:nth-child(4) li:nth-child(1)"))).click().build().perform();
		
		//HoverEnd
		
		onHomePage.hoverMainMenuPurchaseFormsClickThirdPartyLinks();
		
		onHomePage.purchaseButton.click();
		
//		WebElement notificationAboutFillingForm = driver.findElement (By.cssSelector(" div#success"));
//		Thread.sleep(1000);
		onHomePage.waitNotificationAboutFillingForm();
		
		assertEquals(onHomePage.compareNotificationAboutFillingForm(), "Please fill the form.", "Text in notification is incorrect: ");
	}
	
	@AfterClass
	public void tearDown() {
		AwfulValentine.close();
	}
}
