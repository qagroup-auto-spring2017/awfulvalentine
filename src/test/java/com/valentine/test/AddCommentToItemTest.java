package com.valentine.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class AddCommentToItemTest {

	// ProductDetailsPage onProductDetailsPage;
	// CommentDataModel commentDataModel;

	@BeforeClass
	public void setupData() {
		Faker faker = new Faker();
		String name = faker.name().firstName();
		String email = faker.internet().emailAddress();
		String website = faker.internet().url();
		String comment = faker.company().catchPhrase();
	}

	@Test
	public void testAddingAComment() {
		// onProductDetailsPage.addComment(commentDataModel);
	}

	public static void main(String[] args) {
		Faker faker = new Faker();
		String name = faker.name().firstName();
		String email = faker.internet().emailAddress();
		String website = faker.internet().url();
		String comment = faker.company().catchPhrase();

		System.out.println(name + "\n" + email + "\n" + website + "\n" + comment);
		
		String rand1 = RandomStringUtils.randomAlphabetic(12);
		System.out.println(rand1);
		
		System.out.println(RandomStringUtils.randomAscii(10));
	}
}
