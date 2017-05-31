package com.valentine.ViraTarkovska.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.valentine.app.AwfulValentine;
import com.valentine.app.HomePage;
import static org.testng.Assert.*;

public class PurchaseFormsPurchButton_DropTest {
	private HomePage onHomePage;

	@Test
	public void testPurchaseFormsPurchaseButton() throws InterruptedException {

		onHomePage = AwfulValentine.openHomePage();

		onHomePage.hoverMainMenuPurchaseFormsClickThirdPartyLinks();

		onHomePage.purchaseButton.click();

		onHomePage.waitNotificationAboutFillingForm();

		assertEquals(onHomePage.compareNotificationAboutFillingForm(), "Please fill the form.",
				"Text in notification is incorrect: ");
	}

	@AfterClass
	public void tearDown() {
		AwfulValentine.close();
	}
}
