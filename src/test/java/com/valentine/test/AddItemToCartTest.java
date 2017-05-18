package com.valentine.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.valentine.app.AwfulValentine;
import com.valentine.app.HomePage;
import com.valentine.tools.Browser;
import com.valentine.app.ShoppingCartPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;


@Features("Shopping")
@Stories("Add Item to Cart")
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
		assertEquals(onShoppingCartPage.getCurrentUrl(), "http://awful-valentine.com/store/card/",
				"Incorrect URL after click on 'Add to Cart' button");
	}

	@AfterClass
	public void tearDown() {
		AwfulValentine.close();
	}

}
