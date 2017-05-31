package com.valentine.app;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;


public class ContactUsPage {
			
	@FindBy(css = "span[class*='your-name']")
	public WebElement yourNameAlert;
	
	@FindBy(css = "span[class*='your-email']")
	private WebElement yourEmailAlert;
	
	@FindBy(css = "input[name=your-email]+span")
	private WebElement alertEmailInvalid;
	
	@FindBy(name = "your-name")
	public WebElement yourNameField;
	
	@FindBy(name = "your-email")
	public WebElement yourEmailField;
	
	@FindBy(name = "your-subject")
	public WebElement yourSubjectField;
	
	@FindBy(name = "your-message")
	public WebElement yourMessageField;	
	
	
	
	private WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		new WebDriverWait(driver, 10).until(urlToBe("http://awful-valentine.com/contact-us/"));
		PageFactory.initElements(driver, this);
	}
	
	@Step("Click 'Send'")
	public void clickSendButton() {
		driver.findElement(By.cssSelector("p>input[value=Send]")).click();
//		Wait
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		driverWait.until(visibilityOfElementLocated(By.cssSelector(".wpcf7-response-output.wpcf7-display-none.wpcf7-validation-errors")));
	}
	
	//yourNameAlert
	public String getYouNameFieldErrorMessage() {
		return yourNameAlert.getText();
	}
	
	//yourEmailAlert
	public String getYouEmailFieldErrorMessage() {
		return yourEmailAlert.getText();
	}
	
	@Step("Populate 'Contact Us' form")
	public void contactUsFormPopulating(String yourName, String yourEmail, String subject, String yourMessage) {
		yourNameField.sendKeys(yourName);
		yourEmailField.sendKeys(yourEmail);
		yourSubjectField.sendKeys(subject);
		yourMessageField.sendKeys(yourMessage);		
	}
	
	public String getInvalidEmailErrorMessage() {
		return alertEmailInvalid.getText();
	}
	
	
	

}
