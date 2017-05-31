package com.valentine.test;

import com.valentine.app.AwfulValentine;
import com.valentine.tools.App;
import com.valentine.tools.AppTest;

public class AbstractTest implements AppTest {
	protected AwfulValentine awfulValentine = new AwfulValentine();

	@Override
	public App getTestedApp() {
		return this.awfulValentine;
	}

}
