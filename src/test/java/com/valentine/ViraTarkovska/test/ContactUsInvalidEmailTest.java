package com.valentine.ViraTarkovska.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ContactUsInvalidEmailTest {
	private WebDriver driver;

	@Test
	public void testContactUsInvalidEmail() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://awful-valentine.com/contact-us/");
		
						
		driver.findElement(By.name("your-name")).sendKeys("Lee R Cyr");
		driver.findElement(By.name("your-email")).sendKeys("aaa");
		driver.findElement(By.name("your-subject")).sendKeys("Lorem ipsum");
		driver.findElement(By.name("your-message")).sendKeys("Vestibulum id velit sit amet nisi sodales dignissim. Nulla mollis elit sit amet nisl ultricies dictum.");
		
		driver.findElement(By.cssSelector("p>input[value=Send]")).click();
		
		Thread.sleep(2000);
		WebElement alertEmailInvalid = driver.findElement(By.cssSelector("input[name=your-email]+span"));
		Thread.sleep(2000);
		Assert.assertEquals(alertEmailInvalid.getText(), "Email address seems invalid.", "EmailInvalid alert text was checked: ");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
