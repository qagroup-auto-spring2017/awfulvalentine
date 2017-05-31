package com.valentine.tools;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener2;

import com.valentine.app.AwfulValentine;

public class Reporter implements IResultListener2 {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Object testObject = result.getInstance();
		if (testObject instanceof AppTest) {
			((AppTest) testObject).getTestedApp().takeScreenshot();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Object testObject = result.getInstance();
		if (testObject instanceof AppTest) {
			((AppTest) testObject).getTestedApp().takeScreenshot();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Object testObject = result.getInstance();
		if (testObject instanceof AppTest) {
			((AppTest) testObject).getTestedApp().takeScreenshot();
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeConfiguration(ITestResult tr) {
		// TODO Auto-generated method stub

	}

}
