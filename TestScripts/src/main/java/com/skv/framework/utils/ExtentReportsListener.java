package com.skv.framework.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportsListener implements ITestListener {
	private static ExtentReports extent = ExtentReportsManager.createInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println("Extent Reports Logging Started!!!");
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		ExtentTest extentTest = extent.createTest(iTestResult.getMethod().getMethodName(),iTestResult.getMethod().getDescription());
        test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		test.get().pass("TEST CASE PASSED");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		test.get().fail("TEST CASE FAILED");
		test.get().fail(iTestResult.getThrowable());

		try {
			TakeScreenshot ts = new TakeScreenshot();
			String screenshotFile = iTestResult.getName();
			ts.captureScreenShot(screenshotFile);
			
			test.get().addScreenCaptureFromPath("D:\\Workspace\\Automation_Framework\\TestAutomation\\TestScripts\\Resources\\ScreenShots\\" + screenshotFile + ".png");
			// test.get().addScreencastFromPath("E:\\Automation_Framework\\TestAutomation\\TestScripts\\Resources\\ScreenShots");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		test.get().skip("TEST CASE SKIPPED");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	}
}
