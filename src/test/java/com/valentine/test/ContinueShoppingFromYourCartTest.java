package com.valentine.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.valentine.app.AwfulValentine;
import com.valentine.app.HomePage;
import com.valentine.app.ShoppingCartPage;

public class ContinueShoppingFromYourCartTest {

	private HomePage onHomePage;
	private ShoppingCartPage onShoppingCartPage;

	@BeforeClass
	public void setup() {
		onShoppingCartPage = AwfulValentine.openHomePage().addToCartSpecialOffer(1);
	}

	@Test
	public void testContinueShoppingButtonRedirectsToHomePage() {
		onHomePage = onShoppingCartPage.clickContinueShoppingButton();

		assertEquals(onHomePage.getCurrentUrl(), "http://awful-valentine.com/",
				"Incorrect URL after click on 'Continue Shopping' button");
	}

	@Test(dependsOnMethods = "testContinueShoppingButtonRedirectsToHomePage")
	public void testAddingSecondItemToShoppingCart() {
		onShoppingCartPage = onHomePage.addToCartRecentProduct(4);

		assertEquals(onShoppingCartPage.getCurrentUrl(), "http://awful-valentine.com/store/card/",
				"Incorrect URL after adding second item");

		String shoppingCartSummary = onShoppingCartPage.getSummary();
		String youHave2Items = "You have 2 items";

		assertTrue(shoppingCartSummary.startsWith(youHave2Items),
				"\nShopping summary does not start with text: " + youHave2Items + " \n");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		AwfulValentine.close();
	}

}
