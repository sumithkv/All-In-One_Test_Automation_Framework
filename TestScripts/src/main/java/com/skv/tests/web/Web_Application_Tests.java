package com.skv.tests.web;

import org.testng.annotations.Test;

import com.skv.framework.utils.SetWebDriver;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class Web_Application_Tests {

	protected WebDriver driver;

	@BeforeMethod
	@Parameters({ "browser" })
	public void beforeMethod(@Optional("chrome") String browser) {
		System.out.println("Test Started in browser: " + browser.toUpperCase());
		driver = SetWebDriver.getSingletonWebDriverInstance().setWebBrowser(browser);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		System.out.println("Test Stopped in browser: " + driver.getClass().getName());
	}

	@Test(description = "Login Page Test", groups = "WEB")
	@Description("Test Description: Web Application Login Page Test")
	@Epic("NSS v1.2")
	@Feature("Web UI")
	@Story("User Story: Sale From eCommerce UI")
	@Severity(SeverityLevel.TRIVIAL)
	public void loginTest() {
		System.out.println("GUI Method 1 Executed");
		driver.get("http://10.113.130.237:3000/");
	}

	@Test(description = "Home Page Test", groups = "WEB")
	@Description("Test Description: Web Application Home Page Test")
	@Epic("NSS v1.2")
	@Feature("Web UI")
	@Story("User Story: Sale From POS UI")
	@Severity(SeverityLevel.BLOCKER)
	public void homePageTest() {
		System.out.println("GUI Method 2 Executed");
		driver.get("http://www.espncricinfo.com/");
	}

	@Test(description = "Screenshot Capture Test", groups = "WEB")
	@Description("Test Description: Web Application Screenshot Capture Test")
	@Epic("NSS v1.7")
	@Feature("Web UI")
	@Story("User Story: Sale From eCommerce UI")
	@Severity(SeverityLevel.MINOR)
	public void searchProducts() {
		System.out.println("GUI Method 3 Executed");
		driver.get("https://beginnersbook.com/");
		Assert.fail("I Am Failed To Execute...");
	}

	@Test(description = "Product Page Test", groups = "WEB")
	@Description("Test Description: Web Application Product Page Test")
	@Epic("NSS v1.7")
	@Feature("Web UI")
	@Story("User Story: Sale From POS UI")
	@Severity(SeverityLevel.CRITICAL)
	public void addProductTest() {
		System.out.println("GUI Method 4 Executed");
		driver.get("https://www.w3schools.com/");
	}

	@Test(description = "Logout Page Test", groups = "WEB")
	@Description("Test Description: Web Application Logout Page Test")
	@Epic("NSS v2.4")
	@Feature("Web UI")
	@Story("User Story: Sale From eCommerce UI")
	@Severity(SeverityLevel.NORMAL)
	public void logoutTest() {
		System.out.println("GUI Method 5 Executed");
		driver.get("https://www.w3.org/");
	}
}
