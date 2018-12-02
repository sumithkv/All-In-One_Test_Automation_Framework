package com.skv.framework.utils;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestNgTestClass {

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
		SetWebDriver.getSingletonWebDriverInstance().getDriver().manage().deleteAllCookies();
		SetWebDriver.getSingletonWebDriverInstance().getDriver().quit();
	}

}
