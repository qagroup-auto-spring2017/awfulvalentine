package com.valentine.ViraTarkovska.test;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
/*import org.openqa.selenium.chrome.ChromeDriver;*/
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.valentine.app.AwfulValentine;
import com.valentine.app.ContactUsPage;
//import com.valentine.app.HomePage;
//import com.valentine.tools.Browser;
import static org.testng.Assert.*;

public class ContactUsInvalidEmailTest {
//	private WebDriver driver;
	private ContactUsPage onContactUsPage;

	@Test
	public void testContactUsInvalidEmail() throws InterruptedException {
		Faker faker = new Faker();
		/*System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();*/
		/*driver = Browser.open();
		driver.get("http://awful-valentine.com/contact-us/");*/
		onContactUsPage = AwfulValentine.openContactUsPage();
		
		onContactUsPage.contactUsFormPopulating(faker.name().nameWithMiddle(),
				"aaa",
				faker.book().title(),
				faker.shakespeare().hamletQuote());
		
//		driver.findElement(By.name("your-name")).sendKeys("Lee R Cyr");
//		driver.findElement(By.name("your-email")).sendKeys("aaa");
//		driver.findElement(By.name("your-subject")).sendKeys("Lorem ipsum");
//		driver.findElement(By.name("your-message")).sendKeys("Vestibulum id velit sit amet nisi sodales dignissim. Nulla mollis elit sit amet nisl ultricies dictum.");
		
//		driver.findElement(By.cssSelector("p>input[value=Send]")).click();
//		
//		Thread.sleep(2000);
		
		onContactUsPage.clickSendButton();
		
//		WebElement alertEmailInvalid = driver.findElement(By.cssSelector("input[name=your-email]+span"));
//		Thread.sleep(2000);
		assertEquals(onContactUsPage.compareEmailInvalidAlert(), "Email address seems invalid.", "EmailInvalid alert text was checked: ");
		
	}
	
	@AfterClass
	public void tearDown() {
		AwfulValentine.close();
	}
}
