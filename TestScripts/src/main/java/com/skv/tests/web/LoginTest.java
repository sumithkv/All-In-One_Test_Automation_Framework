package com.skv.tests.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.skv.framework.utils.SetWebDriver;
import com.skv.web.pages.HomePage;
import com.skv.web.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginTest {
	WebDriver driver;
	private static String login = "TestUser";
	private static String pass = "Password@123";

	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome") String browser) throws Exception {
		driver = SetWebDriver.getSingletonWebDriverInstance().setWebBrowser(browser);
		driver.get("http://newtours.demoaut.com/mercuryreservation.php");
	}

	@Test(description = "Login Test Using Page Factory", groups = "WEB")
	@Description("Test Description: Login Test Using Page Factory")
	@Epic("NSS v7.1")
	@Feature("Web UI")
	@Story("User Story: Selenium Page Object Model Tests")
	@Severity(SeverityLevel.CRITICAL)
	public void testLogin() {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		HomePage findPage = loginPage.login(login, pass);
		loginPage = findPage.singOff();
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}
