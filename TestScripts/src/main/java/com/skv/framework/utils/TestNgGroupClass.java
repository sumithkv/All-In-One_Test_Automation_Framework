package com.skv.framework.utils;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;

public class TestNgGroupClass {
	@BeforeGroups(groups = "API")
	public void apiSetUp() {
		System.out.println(">>>>> Started API Group Test <<<<<");
	}

	@AfterGroups(groups = "API")
	public void apiTearDown() {
		System.out.println(">>>>> Finished API Group Test <<<<<");
	}

	@BeforeGroups(groups = "Mobile")
	public void mobiSetUp() {
		System.out.println(">>>>> Started Mobile Group Test <<<<<");
	}

	@AfterGroups(groups = "Mobile")
	public void mobiTearDown() {
		System.out.println(">>>>> Finished Mobile Group Test <<<<<");
	}

	@BeforeGroups(groups = "WEB")
	public void webSetUp() {
		System.out.println(">>>>> Started WEB Group Test <<<<<");
	}

	@AfterGroups(groups = "WEB")
	public void webTearDown() {
		System.out.println(">>>>> Finished WEB Group Test <<<<<");
	}
}
