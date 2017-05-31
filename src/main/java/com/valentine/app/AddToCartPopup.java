package com.valentine.app;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.valentine.data.ProductDataModel;

import ru.yandex.qatools.allure.annotations.Step;

public class AddToCartPopup {

	@FindBy(css = ".et_popup_title")
	private WebElement productTitle;

	@FindBy(css = ".Cart66Price")
	private WebElement productPrice;

	@FindBy(css = "[value='Add to Cart']")
	private WebElement addToCartButton;

	private SearchContext searchContext;

	public AddToCartPopup(WebElement root) {
		this.searchContext = root;
		PageFactory.initElements(new DefaultElementLocatorFactory(this.searchContext), this);
	}

	@Step("Check if Popup is displayed")
	public boolean isDisplayed() {
		try {
			return WebElement.class.cast(searchContext).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Step("Read product title")
	public String getTitle() {
		return productTitle.getText();
	}

	@Step("Read product price")
	public double getPrice() {
		String priceText = productPrice.getText();
		priceText = priceText.replaceAll("Price: ", "").replaceAll("\\$", "");
		return Double.parseDouble(priceText);
	}

	@Step("Click 'Add to Cart' button")
	public void addToCart() {
		FluentWait<SearchContext> wait = new FluentWait<SearchContext>(searchContext).ignoring(NoSuchElementException.class);
		wait.until((sc) -> addToCartButton.isDisplayed());

		addToCartButton.click();
	}
	
	@Step("Read Product Info from Popup")
	public ProductDataModel getProductInfoFromPopup() {
		return new ProductDataModel(getTitle(), getPrice());
	}

}
