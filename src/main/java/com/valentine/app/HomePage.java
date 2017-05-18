package com.valentine.app;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.util.List;
//import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage {

	@FindBy(css = "#top-menu>li:nth-child(2)")
	private WebElement ñodeInMainMenu;

	@FindBy(css = "#top-menu>li:nth-child(2) li:nth-child(3)")
	private WebElement chapter3;

	@FindBy(css = "#top-menu>li:nth-child(4)")
	private WebElement mainMenuPurchaseForms;

	@FindBy(css = "#top-menu>li:nth-child(4) li:nth-child(1)")
	private WebElement thirdPartyLinks;

	@FindBy(css = "#go")
	public WebElement purchaseButton;

	@FindBy(css = " div#success")
	public WebElement notificationAboutFillingForm;

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		new WebDriverWait(driver, 10).until(urlToBe("http://awful-valentine.com/"));
		PageFactory.initElements(driver, this);
	}

	public ShoppingCartPage addToCartSpecialOffer(int position) {
		clickAddToCartOnSpecialOffer(position);
		clickAddToCartButtonOnPopup();
		return new ShoppingCartPage(driver);
	}

	public ShoppingCartPage addToCartRecentProduct(int position) {
		clickCartOnRecentProduct(position);
		return clickAddToCartButtonOnPopup();
	}

	/**
	 * Clicks on 'Add to Cart' button on a special offer found by {@code index}
	 * 
	 * @param position
	 *            1-based position in the list
	 */
	@Step("Click 'Add to Cart' button on a special offer number {0}")
	public HomePage clickAddToCartOnSpecialOffer(int position) {
		WebElement specialOffer = specialOffers().get(position - 1);
		specialOffer.findElement(By.cssSelector(".add-to-cart")).click();
		return this;
	}

	private List<WebElement> specialOffers() {
		return driver.findElements(By.cssSelector(".special-item"));
	}

	@Step("Click 'Cart' button on a recent product number {0}")
	public HomePage clickCartOnRecentProduct(int position) {
		WebElement recentProduct = recentProducts().get(position - 1);
		recentProduct.findElement(By.cssSelector(".add-to-cart")).click();
		return this;
	}

	private List<WebElement> recentProducts() {
		return driver.findElements(By.cssSelector(".main-product"));
	}

	@Step("Check if 'Add to Cart' Popup is displayed")
	public boolean isAddToCartPopupShown() {
		return addToCartPopup().isDisplayed();
	}

	@Step("Read product title on popup")
	@Attachment("Product title")
	public String getPopupProductTitle() {
		return addToCartPopup().findElement(By.cssSelector(".et_popup_title")).getText();
	}

	@Step("Click 'Add to Cart' button on popup")
	public ShoppingCartPage clickAddToCartButtonOnPopup() {
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		driverWait.until(visibilityOfElementLocated(By.cssSelector("#fancybox-wrap [value='Add to Cart']")));

		addToCartPopup().findElement(By.cssSelector("[value='Add to Cart']")).click();
		return new ShoppingCartPage(driver);
	}

	private WebElement addToCartPopup() {
		return driver.findElement(By.id("fancybox-wrap"));
	}

	@Step("Read current URL")
	@Attachment("URL")
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void hoverCodeInMainMenuClickOnCode() {
		Actions actions = new Actions(driver);
		actions.moveToElement(ñodeInMainMenu);

		actions.moveToElement(chapter3);
		actions.click().build().perform();
	}

	public String getCurrentUrlChapter3() {
		return driver.getCurrentUrl();
	}

	public void hoverMainMenuPurchaseFormsClickThirdPartyLinks() {
		Actions actions = new Actions(driver);
		actions.moveToElement(mainMenuPurchaseForms);

		actions.moveToElement(thirdPartyLinks);
		actions.click().build().perform();
	}

	public void waitNotificationAboutFillingForm() {
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		driverWait.until(visibilityOfElementLocated(By.cssSelector(" div#success")));
	}

	

}
