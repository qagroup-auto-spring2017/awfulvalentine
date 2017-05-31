package com.valentine.ViraTarkovska.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.valentine.app.AwfulValentine;
import com.valentine.app.HomePage;
import static org.testng.Assert.*;

public class CodeDropdownChapter3OpensTest {
	private HomePage onHomePage;

	@Test
	public void testCodeDropdownChapter3Opens() {

		onHomePage = AwfulValentine.openHomePage();

		onHomePage.hoverCodeInMainMenuClickOnChapter3();

		assertEquals(onHomePage.getCurrentUrl(), "http://awful-valentine.com/code/chapter-3/",
				"Incorrect URL after click on 'Capter 3' button: ");

	}

	@AfterClass
	public void tearDown() {
		AwfulValentine.close();
	}

}
