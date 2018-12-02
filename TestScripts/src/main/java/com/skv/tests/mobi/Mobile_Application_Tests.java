package com.skv.tests.mobi;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Mobile_Application_Tests {

	@Test(description = "Lauching App", groups = "Mobile")
	@Description("Test Description: Launching My Mobile App")
	@Epic("NSS v1.2")
	@Feature("Mobile Feature")
	@Story("User Story: POS UI in Android Mobile")
	@Severity(SeverityLevel.CRITICAL)
	public void lauchApp() {
		System.out.println("Mobile Method 1 Executed");
	}

	@Test(description = "Refreshing App", groups = "Mobile")
	@Description("Test Description: Refreshing The App Using Power Button")
	@Epic("NSS v1.2")
	@Feature("Mobile Feature")
	@Story("User Story: POS UI in Android Mobile")
	@Severity(SeverityLevel.NORMAL)
	public void refreshApp() {
		System.out.println("Mobile Method 2 Executed");
	}

	@Test(description = "Updating The App", groups = "Mobile")
	@Description("Test Description: Updating The App From Play Store")
	@Epic("NSS v1.7")
	@Feature("Mobile Feature")
	@Story("User Story: POS UI in Android Mobile")
	@Severity(SeverityLevel.NORMAL)
	public void updateApp() {
		System.out.println("Mobile Method 3 Executed");
	}

	@Test(description = "Exiting The App", groups = "Mobile")
	@Description("Test Description: Exiting The App By Clicking Close Button")
	@Epic("NSS v1.7")
	@Feature("Mobile Feature")
	@Story("User Story: POS UI in Android Mobile")
	@Severity(SeverityLevel.MINOR)
	public void exitApp() {
		System.out.println("Mobile Method 4 Executed");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method for Mobile Test is Called");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method for Mobile Test is Called");

	}

}
