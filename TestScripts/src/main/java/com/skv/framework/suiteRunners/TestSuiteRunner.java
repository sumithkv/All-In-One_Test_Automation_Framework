package com.skv.framework.suiteRunners;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class TestSuiteRunner {

	public static void main(String[] args) {

		System.out.println(">>>>> Started The Automation Suite <<<<<");

		TestNG tng = new TestNG();
		TestListenerAdapter tla = new TestListenerAdapter();
		List<String> suites = Lists.newArrayList();
		suites.add("testng.xml");
		tng.setTestSuites(suites);
		tng.addListener(tla);
		tng.run();

		System.out.println(">>>>> Finished The Automation Suite <<<<<");
		System.out.println("PASSED Tests = " + tla.getPassedTests().size());
		System.out.println("FAILED Tests = " + tla.getFailedTests().size());
		System.out.println("SKIPPED Tests = " + tla.getSkippedTests().size());
	}

}
