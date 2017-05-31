package com.valentine.app;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {
	
	@FindBy(id = "continueShopping")
	private WebElement continueShoppingButton;

	@FindBy(id = "Cart66WidgetCartEmptyAdvanced")
	private WebElement summary;

	private WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		new WebDriverWait(driver, 10).until(urlContains("cart"));
		PageFactory.initElements(driver, this);
	}

	public HomePage clickContinueShoppingButton() {
		continueShoppingButton.click();
		return new HomePage(driver);
	}

	public String getSummary() {
		return summary.getText();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
