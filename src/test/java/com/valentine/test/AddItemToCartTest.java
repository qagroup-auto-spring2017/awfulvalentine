package com.valentine.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.valentine.app.AwfulValentine;
import com.valentine.app.HomePage;
import com.valentine.app.ShoppingCartPage;

public class AddItemToCartTest {
	private HomePage onHomePage;
	private ShoppingCartPage onShoppingCartPage;

	@Test
	public void testTheAddCartButtonOpensPopup() {
		onHomePage = AwfulValentine.openHomePage();
		onHomePage.clickAddToCartOnSpecialOffer(1);

		assertTrue(onHomePage.isAddToCartPopupShown(), "'Add to cart' Popup did not appear.");

		String productTitle = onHomePage.getPopupProductTitle();
		assertEquals(productTitle, "Closeness and Togetherness", "Incorrect product title on 'Add to Cart' popup");
	}

	@Test(dependsOnMethods = "testTheAddCartButtonOpensPopup")
	public void testAddToCartButtonOnPopupRedirectsToCartPage() {
		onShoppingCartPage = onHomePage.clickAddToCartButtonOnPopup();
		assertEquals(onShoppingCartPage.getCurrentUrl(), "http://awful-valentine.com/store/cart/",
				"Incorrect URL after click on 'Add to Cart' button");
	}

	@AfterClass
	public void tearDown() {
		AwfulValentine.close();
	}

}
