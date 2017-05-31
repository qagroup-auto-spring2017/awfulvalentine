package com.valentine.ViraTarkovska.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import com.valentine.app.AwfulValentine;
import com.valentine.app.ContactUsPage;
import static org.testng.Assert.*;

public class ContactUsInvalidEmailTest {
	private ContactUsPage onContactUsPage;

	@Test
	public void testContactUsInvalidEmail() throws InterruptedException {
		Faker faker = new Faker();

		onContactUsPage = AwfulValentine.openContactUsPage();

		onContactUsPage.contactUsFormPopulating(faker.name().nameWithMiddle(), "aaa", faker.book().title(),
				faker.shakespeare().hamletQuote());

		onContactUsPage.clickSendButton();

		assertEquals(onContactUsPage.getInvalidEmailErrorMessage(), "Email address seems invalid.",
				"EmailInvalid alert text was checked: ");

	}

	@AfterClass
	public void tearDown() {
		AwfulValentine.close();
	}
}
