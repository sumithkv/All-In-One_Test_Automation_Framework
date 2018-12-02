package com.skv.framework.utils;

import java.util.List;
import java.util.Set;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestNgTestListener extends TestListenerAdapter {

	@Override
	public void onTestStart(ITestResult result) {

		super.onTestStart(result);

		TestScriptsLogger.info("Started Test Instance : " + result.getInstanceName());
		TestScriptsLogger.info("Started Test Method : " + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult tr) {

		super.onTestSuccess(tr);

		TestScriptsLogger.info("Test Case: " + tr.getInstanceName() + " is PASSED");
		TestScriptsLogger.info("Status of the Test is : " + tr.getStatus());
	}

	@Override
	public void onTestFailure(ITestResult tr) {

		super.onTestFailure(tr);

		TestScriptsLogger.info("The Test Case: " + tr.getInstanceName() + " is FAILED");
		TestScriptsLogger.info("Status of the Test is : " + tr.getStatus());

		// Here we can write method for taking screenshots
	}

	@Override
	public void onTestSkipped(ITestResult tr) {

		super.onTestSkipped(tr);

		TestScriptsLogger.info("The Test Case: " + tr.getInstanceName() + " is SKIPPED");
		TestScriptsLogger.info("Status of the Test is : " + tr.getStatus());
	}

	@Override
	public void onStart(ITestContext testContext) {

		super.onStart(testContext);

		TestScriptsLogger.info(
				"*************************************************************************************************");
		TestScriptsLogger.info("Test Start Time: " + testContext.getStartDate());
		TestScriptsLogger.info("Test SUITE Name is: " + testContext.getSuite().getName());
		TestScriptsLogger.info("Test TEST Name is: " + testContext.getName());
		TestScriptsLogger.info(
				"*************************************************************************************************");
	}

	@Override
	public void onFinish(ITestContext testContext) {

		super.onFinish(testContext);

		TestScriptsLogger.info(
				"###############################################################################################################################");
		TestScriptsLogger.info("Number of Passed Tests: " + testContext.getPassedTests().size());
		TestScriptsLogger.info("Number of Failed Tests: " + testContext.getFailedTests().size());
		TestScriptsLogger.info("Number of Skipped Tests: " + testContext.getSkippedTests().size());

		TestScriptsLogger.info("Included Groups: " + testContext.getIncludedGroups());
		TestScriptsLogger.info("Excluded Groups: " + testContext.getExcludedGroups());

		TestScriptsLogger.info("PASSED TESTS");

		Set<ITestResult> s = testContext.getPassedTests().getAllResults();

		int i = 0;
		for (ITestResult r : s) {
			i++;
			TestScriptsLogger.info(i + ": " + r.getInstanceName());
		}

		TestScriptsLogger.info("FAILED TESTS");

		Set<ITestResult> f = testContext.getFailedTests().getAllResults();

		int j = 0;
		for (ITestResult r : f) {
			j++;
			TestScriptsLogger.info(j + ": " + r.getInstanceName());
		}

		TestScriptsLogger.info("Test Finish Time: " + testContext.getEndDate());
		TestScriptsLogger.info(
				"###############################################################################################################################");

	}

	@Override
	public List<ITestResult> getPassedTests() {

		return super.getPassedTests();
	}

	@Override
	public List<ITestResult> getFailedTests() {

		return super.getFailedTests();
	}

	@Override
	public List<ITestResult> getSkippedTests() {

		return super.getSkippedTests();
	}

	@Override
	public void beforeConfiguration(ITestResult tr) {

		super.beforeConfiguration(tr);
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {

		super.onConfigurationSuccess(itr);
	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {

		super.onConfigurationFailure(itr);
	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {

		super.onConfigurationSkip(itr);
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestFailedButWithinSuccessPercentage(tr);
	}

	@Override
	protected ITestNGMethod[] getAllTestMethods() {
		// TODO Auto-generated method stub
		return super.getAllTestMethods();
	}

	@Override
	public List<ITestResult> getFailedButWithinSuccessPercentageTests() {
		// TODO Auto-generated method stub
		return super.getFailedButWithinSuccessPercentageTests();
	}

	@Override
	public void setAllTestMethods(List<ITestNGMethod> allTestMethods) {
		// TODO Auto-generated method stub
		super.setAllTestMethods(allTestMethods);
	}

	@Override
	public void setFailedButWithinSuccessPercentageTests(List<ITestResult> failedButWithinSuccessPercentageTests) {
		// TODO Auto-generated method stub
		super.setFailedButWithinSuccessPercentageTests(failedButWithinSuccessPercentageTests);
	}

	@Override
	public void setFailedTests(List<ITestResult> failedTests) {
		// TODO Auto-generated method stub
		super.setFailedTests(failedTests);
	}

	@Override
	public void setPassedTests(List<ITestResult> passedTests) {
		// TODO Auto-generated method stub
		super.setPassedTests(passedTests);
	}

	@Override
	public void setSkippedTests(List<ITestResult> skippedTests) {
		// TODO Auto-generated method stub
		super.setSkippedTests(skippedTests);
	}

	@Override
	public List<ITestContext> getTestContexts() {
		// TODO Auto-generated method stub
		return super.getTestContexts();
	}

	@Override
	public List<ITestResult> getConfigurationFailures() {
		// TODO Auto-generated method stub
		return super.getConfigurationFailures();
	}

	@Override
	public List<ITestResult> getConfigurationSkips() {
		// TODO Auto-generated method stub
		return super.getConfigurationSkips();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
