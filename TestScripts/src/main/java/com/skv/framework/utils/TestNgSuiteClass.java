package com.skv.framework.utils;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgSuiteClass {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("***** Started The Test Suite *****");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("***** Finished The Test Suite *****");
	}

}
