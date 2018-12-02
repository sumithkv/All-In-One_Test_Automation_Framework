package com.skv.framework.utils;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class TestNgSuiteListener implements ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		TestScriptsLogger.info("TEST SUITE " + suite.getName() + " STARTED");
	}

	@Override
	public void onFinish(ISuite suite) {
		TestScriptsLogger.info("TEST SUITE " + suite.getName() + " FINISHED");
	}
}
