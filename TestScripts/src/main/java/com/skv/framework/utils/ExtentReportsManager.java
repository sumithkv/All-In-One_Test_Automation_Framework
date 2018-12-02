package com.skv.framework.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManager {
	private static ExtentReports extent;
	private static String extentReportFile = "D:\\Workspace\\Automation_Framework\\TestAutomation\\TestScripts\\test-output\\TestResults-ExtentReport.html";

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	public static ExtentReports createInstance() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(new File(extentReportFile));
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Automation Dashboard");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Automation Execution Status");
		
		extent = new ExtentReports();
		extent.setSystemInfo("Author", "Sumith K.V");
		extent.setSystemInfo("Build", "TCxElevate_V2R1_B1207");
		extent.setSystemInfo("App Server", "Weblogic");
		extent.setSystemInfo("Database", "DB2");
		extent.setSystemInfo("Operating System", "Windows 2012 R2");
		extent.attachReporter(htmlReporter);
		return extent;
	}
}
