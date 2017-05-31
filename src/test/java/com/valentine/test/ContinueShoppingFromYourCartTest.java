package com.valentine.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.valentine.app.AwfulValentine;
import com.valentine.app.HomePage;
import com.valentine.app.ShoppingCartPage;
import com.valentine.tools.App;
import com.valentine.tools.AppTest;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

@Features("Shopping")
@Stories("Continue Shopping from Cart page")
public class ContinueShoppingFromYourCartTest implements AppTest {

	private HomePage onHomePage;
	private ShoppingCartPage onShoppingCartPage;
	private AwfulValentine awfulValentine = new AwfulValentine();

	@BeforeClass
	public void setup() {
		onShoppingCartPage = awfulValentine.openHomePage().addToCartSpecialOffer(1);
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

		assertEquals(onShoppingCartPage.getCurrentUrl(), "http://awful-valentine.com/store/cart/",
				"Incorrect URL after adding second item");

		String shoppingCartSummary = onShoppingCartPage.getSummary();
		String youHave2Items = "You have 2 items";

		assertTrue(shoppingCartSummary.startsWith(youHave2Items),
				"\nShopping summary does not start with text: " + youHave2Items + " \n");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		awfulValentine.close();
	}

	@Override
	public App getTestedApp() {
		return this.awfulValentine;
	}

}
