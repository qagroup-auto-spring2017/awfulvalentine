package com.valentine.app;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {

	private WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		new WebDriverWait(driver, 10).until(urlContains("cart"));
	}

	public HomePage clickContinueShoppingButton() {
		continueShoppingButton().click();
		return new HomePage(driver);
	}

	private WebElement continueShoppingButton() {
		return driver.findElement(By.id("continueShopping"));
	}

	public String getSummary() {
		return summaryElement().getText();
	}

	private WebElement summaryElement() {
		return driver.findElement(By.id("Cart66WidgetCartEmptyAdvanced"));
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
