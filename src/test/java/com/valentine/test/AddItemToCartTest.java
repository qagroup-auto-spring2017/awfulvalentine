package com.valentine.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.valentine.app.AwfulValentine;
import com.valentine.app.HomePage;
<<<<<<< HEAD
import com.valentine.tools.Browser;
=======
import com.valentine.app.ShoppingCartPage;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
>>>>>>> 2852471f7ad9f91bcad930da6f921bb9d56f0ae1

@Features("Shopping")
@Stories("Add Item to Cart")
public class AddItemToCartTest {
<<<<<<< HEAD
	private WebDriver driver;
	private HomePage homePage;

	@Test
	public void testTheAddCartButtonOpensPopup() {
		/*driver = Browser.open();
		driver.get("http://awful-valentine.com/");*/
		
		homePage = AwfulValentine.openHomePage();
		

		driver.findElement(By.cssSelector("[href='#et-offer-post-30']")).click();
		WebElement addToCartPopup = driver.findElement(By.id("fancybox-wrap"));
=======
	private HomePage onHomePage;
	private ShoppingCartPage onShoppingCartPage;

	@Test
	public void testTheAddCartButtonOpensPopup() {
		onHomePage = AwfulValentine.openHomePage();
		onHomePage.clickAddToCartOnSpecialOffer(1);
>>>>>>> 2852471f7ad9f91bcad930da6f921bb9d56f0ae1

		assertTrue(onHomePage.isAddToCartPopupShown(), "'Add to cart' Popup did not appear.");

		String productTitle = onHomePage.getPopupProductTitle();
		assertEquals(productTitle, "Closeness and Togetherness", "Incorrect product title on 'Add to Cart' popup");
	}

	@Test(dependsOnMethods = "testTheAddCartButtonOpensPopup")
	public void testAddToCartButtonOnPopupRedirectsToCartPage() {
		onShoppingCartPage = onHomePage.clickAddToCartButtonOnPopup();
		assertEquals(onShoppingCartPage.getCurrentUrl(), "http://awful-valentine.com/store/card/",
				"Incorrect URL after click on 'Add to Cart' button");
	}

	@AfterClass
	public void tearDown() {
		AwfulValentine.close();
	}

}
