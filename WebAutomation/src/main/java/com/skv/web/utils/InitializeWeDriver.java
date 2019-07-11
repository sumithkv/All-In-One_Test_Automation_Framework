package com.skv.web.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitializeWeDriver {
	
	// Static member of the class
	private static InitializeWeDriver initializeWebDriver;
	
	public static WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	// Private Constructor
	private InitializeWeDriver() {
    }

	// Global point of access
	public static InitializeWeDriver getSingletonWebDriverInstance() {
        if (null == initializeWebDriver) {
        	initializeWebDriver = new InitializeWeDriver();
        }
        return initializeWebDriver;
    }

	
	public WebDriver setWebBrowser(String Browser) {

		if (Browser.equalsIgnoreCase("firefox"))

		{
			System.setProperty("webdriver.gecko.driver",
					"D:\\Workspace\\Automation_Framework\\TestAutomation\\TestScripts\\Resources\\Drivers\\geckodriver.exe");
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile autoProfile = profile.getProfile("AutoFox");
			autoProfile.setPreference("browser.startup.homepage", "https://www.google.com/");
			// autoProfile.setPreference("network.proxy.http","http://UserName:Password@myproxy.company.net:8080");
			// autoProfile.setPreference("network.proxy.http", "172.28.84.6");
			// autoProfile.setPreference("network.proxy.http_port", "3128");
			// autoProfile.setPreference("network.proxy.proxy.type", "1");
			autoProfile.setAcceptUntrustedCertificates(true);
			autoProfile.setAssumeUntrustedCertificateIssuer(false);
			driver = new FirefoxDriver(autoProfile);
		}

		else if (Browser.equalsIgnoreCase("chrome"))

		{
			System.setProperty("webdriver.chrome.driver",
					"D:\\Workspace\\Automation_Framework\\TestAutomation\\TestScripts\\Resources\\Drivers\\chromedriver.exe");
			ChromeOptions autoOptions = new ChromeOptions();
			autoOptions.addArguments("test-type");
			autoOptions.addArguments("start-maximized");
			autoOptions.addArguments("--enable-automation");
			autoOptions.addArguments("test-type=browser");
			autoOptions.addArguments("disable-infobars");
			driver = new ChromeDriver(autoOptions);
		}

		else if (Browser.equalsIgnoreCase("edge"))

		{
			System.setProperty("webdriver.edge.driver",
					"D:\\Workspace\\Automation_Framework\\TestAutomation\\TestScripts\\Resources\\Drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}

		else if (Browser.equalsIgnoreCase("ie32"))

		{
			System.setProperty("webdriver.ie.driver",
					"D:\\Workspace\\Automation_Framework\\TestAutomation\\TestScripts\\Resources\\Drivers\\IE32\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		else if (Browser.equalsIgnoreCase("ie64"))

		{
			System.setProperty("webdriver.ie.driver",
					"D:\\Workspace\\Automation_Framework\\TestAutomation\\TestScripts\\Resources\\Drivers\\IE64\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		else {
			System.out.println("ERROR: Invalid Web Browser!!! Please recheck the Web Browser Specified");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.MINUTES);

		return driver;
	}
}
