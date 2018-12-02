package com.skv.framework.suiteRunners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlGroups;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class DynamicTestSuiteRunner {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Create an instance on TestNG
		TestNG myTestNG = new TestNG();

		// Create an instance of XML Suite and assign a name for it.
		XmlSuite mySuite = new XmlSuite();
		mySuite.setName("MySuite");
		mySuite.setParallel(XmlSuite.ParallelMode.TESTS);

		// Create an instance of XmlTest and assign a name for it.
		XmlTest myTest = new XmlTest(mySuite);
		myTest.setName("MyTest");

		// This Map can hold your testng Parameters.
		Map<String, String> testngParams = new HashMap<String, String>();
		testngParams.put("Param1", "Value_1");
		testngParams.put("Param2", "Value_2");
		testngParams.put("Param3", "Value_3");
		// Add any parameters that you want to set to the Test.
		myTest.setParameters(testngParams);

		// Adding groups that you want to include in the Test.
		XmlGroups grp = new XmlGroups();
		List<String> inGroups = new ArrayList<String>();
		inGroups.add("InGrp1");
		inGroups.add("InGrp2");
		inGroups.add("InGrp3");
		List<String> exGroups = new ArrayList<String>();
		exGroups.add("ExGrp1");
		exGroups.add("ExGrp2");
		myTest.setIncludedGroups(inGroups);
		myTest.setExcludedGroups(exGroups);

		// Create a list which can contain the packages that you want to run.
		List<XmlPackage> myPackages = new ArrayList<XmlPackage>();
		myPackages.add(null);
		myTest.setXmlPackages(myPackages);

		// Create a list which can contain the classes that you want to run.
		List<XmlClass> myClasses = new ArrayList<XmlClass>();
		myClasses.add(new XmlClass("ThreadSample"));

		// Assign that to the XmlTest Object created earlier.
		myTest.setXmlClasses(myClasses);

		// Create a list of XmlTests and add the Xmltest you created earlier to it.
		List<XmlTest> myTests = new ArrayList<XmlTest>();
		myTests.add(myTest);

		// add the list of tests to your Suite.
		mySuite.setTests(myTests);

		// Add the suite to the list of suites.
		List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
		mySuites.add(mySuite);

		// Set the list of Suites to the testNG object you created earlier.
		myTestNG.setXmlSuites(mySuites);
		mySuite.setFileName("myTemp.xml");
		mySuite.setThreadCount(3);
		myTestNG.run();

	}

}
