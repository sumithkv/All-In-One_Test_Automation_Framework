package com.skv.framework.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class TakeScreenshot {
	
	protected WebDriver driver = SetWebDriver.getSingletonWebDriverInstance().getDriver();
	
	public void captureScreenShot(String testName) throws Exception {
		
		File file = new File("E:\\Workspace\\Automation_Framework\\TestAutomation\\TestScripts\\Resources\\ScreenShots\\" + testName + ".png");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, file);
	}
	
	@Attachment(value="Failure Page Screenshot", type = "image/png")
	public byte[] embedScreenShot(String testName) throws Exception {
		
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);			
				return screenshot;
	}
	
	@Attachment(value="{0}", type = "text/plain")
	public String saveLogs(ITestResult result) throws Exception {
		
		return "Screenshot Logs: " + result.getThrowable().getStackTrace().toString();
	}
}
