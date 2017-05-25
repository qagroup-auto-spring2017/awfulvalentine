package com.valentine.tools;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener2;

import com.valentine.app.AwfulValentine;

public class Reporter implements IResultListener2 {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		AwfulValentine.takeScreenshot();
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		AwfulValentine.takeScreenshot();

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		AwfulValentine.takeScreenshot();

	}

	@Override
	public void onConfigurationFailure(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationSkip(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeConfiguration(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	// public void createScreenshot(){
	// AwfulValentine.takeScreenshot();
	// }

}
