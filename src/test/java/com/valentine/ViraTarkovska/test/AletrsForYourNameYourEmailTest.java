package com.valentine.ViraTarkovska.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.valentine.app.AwfulValentine;
import com.valentine.app.ContactUsPage;
import static org.testng.Assert.*;

public class AletrsForYourNameYourEmailTest {
	private ContactUsPage onContactUsPage;

	@Test
	public void testAletrsForYourNameYourEmail() throws InterruptedException {

		onContactUsPage = AwfulValentine.openContactUsPage();

		onContactUsPage.clickSendButton();

		assertEquals(onContactUsPage.getYouNameFieldErrorMessage(), "Please fill the required field.",
				"YourName alert text was checked: ");

		assertEquals(onContactUsPage.getYouEmailFieldErrorMessage(), "Please fill the required field.",
				"YourName alert text was checked: ");

	}

	@AfterClass

	public void tearDown() {
		AwfulValentine.close();
	}

}
