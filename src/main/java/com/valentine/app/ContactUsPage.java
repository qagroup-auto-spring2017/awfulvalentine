package com.valentine.app;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ContactUsPage {
			
	@FindBy(css = "span[class*='your-name']")
	public WebElement yourNameAlert;
	
	@FindBy(css = "span[class*='your-email']")
	private WebElement yourEmailAlert;
	
	@FindBy(css = "input[name=your-email]+span")
	private WebElement alertEmailInvalid;
	
	
	private WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		new WebDriverWait(driver, 10).until(urlToBe("http://awful-valentine.com/contact-us/"));
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickSendButton() {
		driver.findElement(By.cssSelector("p>input[value=Send]")).click();
//		Wait
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		driverWait.until(visibilityOfElementLocated(By.cssSelector(".wpcf7-response-output.wpcf7-display-none.wpcf7-validation-errors")));
	}
	
	//yourNameAlert
	public String compareYourNameAlert() {
		return yourNameAlert.getText();
	}
	
//	private WebElement yourNameAlert() {
//		return driver.findElement(By.cssSelector("span[class*='your-name']"));
//	}
	
	//yourEmailAlert
	public String compareYourEmailAlert() {
		return yourEmailAlert.getText();
	}
	
//	private WebElement yourEmailAlert() {
//		return driver.findElement(By.cssSelector("span[class*='your-email']"));
//	}

	
	
	public void populateYourName() {
		driver.findElement(By.name("your-name")).sendKeys("Lee R Cyr");		
	}

	public void populateYourEmail() {
		driver.findElement(By.name("your-email")).sendKeys("aaa");		
	}

	public void populateSubject() {
		driver.findElement(By.name("your-subject")).sendKeys("Lorem ipsum");		
	}

	public void populateYourMessage() {
		driver.findElement(By.name("your-message")).sendKeys("Vestibulum id velit sit amet nisi sodales dignissim. Nulla mollis elit sit amet nisl ultricies dictum.");		
	}
	
	public String compareEmailInvalidAlert() {
		return alertEmailInvalid.getText();
	}
	
	
	

}
