package com.valentine.ViraTarkovska.test;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
/*import org.openqa.selenium.chrome.ChromeDriver;*/
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.valentine.app.AwfulValentine;
import com.valentine.app.ContactUsPage;
//import com.valentine.app.ContactUsPage;
//import com.valentine.tools.Browser;
import static org.testng.Assert.*;

public class AletrsForYourNameYourEmailTest {
	private ContactUsPage onContactUsPage;

	@Test
	public void testAletrsForYourNameYourEmail() throws InterruptedException {
		/*
		 * System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 * driver = new ChromeDriver();
		 */
		/*
		 * driver = Browser.open();
		 * driver.get("http://awful-valentine.com/contact-us/");
		 */
		onContactUsPage = AwfulValentine.openContactUsPage();

		/* driver.findElement(By.cssSelector("input[value='Send']")).click(); */

		onContactUsPage.clickSendButton();

		// WebElement alertYourName =
		// driver.findElement(By.cssSelector("span[class*='your-name']"));
		// Thread.sleep(1000);
		// Assert.assertEquals(alertYourName.getText(), "Please fill the
		// required field.","YourName alert text was checked: ");

		assertEquals(onContactUsPage.compareYourNameAlert(), "Please fill the required field.",
				"YourName alert text was checked: ");

		/*
		 * WebElement alertYourEmail =
		 * driver.findElement(By.cssSelector("span[class*='your-email']"));
		 * Assert.assertEquals(alertYourEmail.getText(),
		 * "Please fill the required field.",
		 * "YourEmail alert text was checked: ");
		 */

		assertEquals(onContactUsPage.compareYourEmailAlert(), "Please fill the required field.",
				"YourName alert text was checked: ");

	}

	@AfterClass
	/*
	 * public void tearDown() { driver.close(); }
	 */

	public void tearDown() {
		AwfulValentine.close();
	}

}
