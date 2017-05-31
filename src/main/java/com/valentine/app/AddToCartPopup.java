package com.valentine.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.FluentWait;

import com.valentine.data.ProductDataModel;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class AddToCartPopup {

	@FindBy(css = ".et_popup_title")
	private WebElement title;

	@FindBy(css = ".Cart66Price")
	private WebElement price;

	@FindBy(css = "[value='Add to Cart']")
	private WebElement addToCartButton;

	private SearchContext root;

	public AddToCartPopup(WebElement root) {
		this.root = root;
		PageFactory.initElements(new DefaultElementLocatorFactory(this.root), this);
	}

	@Step("Check if 'Add to Cart' Popup is displayed")
	public boolean isDisplayed() {
		try {
			return WebElement.class.cast(root).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Step("Read title")
	public String getTitle() {
		return title.getText();
	}

	@Step("Read price")
	@Attachment("Price")
	public double getPrice() {
		String priceText = price.getText();
		priceText = priceText.replaceAll("Price: ", "").replaceAll("\\$", "");
		return Double.parseDouble(priceText);
	}

	@Step("Read price")
	@Attachment("Price")
	public String getPriceAsText() {
		return price.getText();
	}

	@Step("Click 'Add to Cart' button")
	public void clickAddToCartButton() {
		FluentWait<SearchContext> wait = new FluentWait<>(root).withTimeout(10, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class).withMessage("'Add to Cart' button did not appear!");

		wait.until((SearchContext sc) -> addToCartButton.isDisplayed());

		addToCartButton.click();
	}

	@Step("Read Product Info from Popup")
	public ProductDataModel getProductInfo() {
		return new ProductDataModel(getTitle(), getPrice());
	}
}
