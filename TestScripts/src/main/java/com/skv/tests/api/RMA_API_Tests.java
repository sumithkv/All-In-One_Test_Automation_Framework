package com.skv.tests.api;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.skv.api.apiObjects.StoreMgmtApi;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class RMA_API_Tests {

	StoreMgmtApi api = new StoreMgmtApi();
	HashMap<String, String> pMap = new HashMap<String, String>();
	HashMap<String, String> qMap = new HashMap<String, String>();

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method for API Test is Called");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method for API Test is Called");
	}

	@Test(description = "RMA API Test 1", groups = "API")
	@Epic("NSS v1.2")
	@Feature("REST API Test")
	@Story("User Story: POS UI REST API Invocation")
	@Severity(SeverityLevel.CRITICAL)
	public void GetResponse() {
		api.getResponse("/storemgmt/v1/stores");
	}

	@Test(description = "RMA API Test 2", groups = "API")
	@Epic("NSS v2.1")
	@Feature("REST API Test")
	@Story("User Story: POS UI REST API Invocation")
	@Severity(SeverityLevel.NORMAL)
	public void GetResponseCode() {
		api.getResponseCode("/storemgmt/v1/stores");
	}

	@Test(description = "RMA API Test 3", groups = "API")
	@Epic("NSS v1.2")
	@Feature("REST API Test")
	@Story("User Story: POS UI REST API Invocation")
	@Severity(SeverityLevel.NORMAL)
	public void GetResponseMessage() {
		api.getResponseMessage("/storemgmt/v1/stores");
	}

	@Test(description = "RMA API Test 4", groups = "API")
	@Epic("NSS v1.2")
	@Feature("REST API Test")
	@Story("User Story: POS UI REST API Invocation")
	@Severity(SeverityLevel.CRITICAL)
	public void VerifyValidResponseCode() {
		api.getResponse("/storemgmt/v1/stores");
		api.verifyResponseCode(200);
	}

	@Test(description = "RMA API Test 5", groups = "API")
	@Epic("NSS v1.2")
	@Feature("REST API Test")
	@Story("User Story: POS UI REST API Invocation")
	@Severity(SeverityLevel.NORMAL)
	public void VerifyInvalidResponseCode() {
		api.getResponse("/storemgmt/v1/store/123");
		api.verifyResponseCode(400);
	}

	@Test(description = "RMA API Test 6", groups = "API")
	@Epic("NSS v3.7")
	@Feature("REST API Test")
	@Story("User Story: POS UI REST API Invocation")
	@Severity(SeverityLevel.NORMAL)
	public void VerifyValidResponseMessage() {
		api.getResponse("/storemgmt/v1/stores");
		api.verifyResponseMessage("HTTP/1.1 200 OK");
	}

	@Test(description = "RMA API Test 7", groups = "API")
	@Epic("NSS v1.2")
	@Feature("REST API Test")
	@Story("User Story: POS UI REST API Invocation")
	@Severity(SeverityLevel.BLOCKER)
	public void VerifyInvalidResponseMessage() {
		api.getResponse("/storemgmt/v1/store/248");
		api.verifyResponseMessage("HTTP/1.1 400 Bad Request");
	}

	@Test(description = "RMA API Test 8", groups = "API")
	@Epic("NSS v1.7")
	@Feature("REST API Test")
	@Story("User Story: POS UI REST API Invocation")
	@Severity(SeverityLevel.CRITICAL)
	public void postRequestXML() {
		api.postRequest("/storemgmt/v1/stores",
				"E:\\Automation_Framework\\TestAutomation\\TestScripts\\Resources\\TestData\\RMA_Store_123.xml", "XML");
	}

	@Test(description = "RMA API Test 9", groups = "API")
	@Epic("NSS v1.2")
	@Feature("REST API Test")
	@Story("User Story: POS UI REST API Invocation")
	@Severity(SeverityLevel.CRITICAL)
	public void getHeader() {
		api.getResponse("/storemgmt/v1/store/1");
		api.getHeaderValue("Date");
	}

	@Test(description = "RMA API Test 10", groups = "API")
	@Epic("NSS v1.2")
	@Feature("REST API Test")
	@Story("User Story: POS UI REST API Invocation")
	@Severity(SeverityLevel.NORMAL)
	public void VerifyHeader() {
		api.getResponse("/storemgmt/v1/store/1");
		api.verifyHeaderValue("Server", "Jetty(9.3.15.v20161220)");
	}

	@Test(description = "RMA API Test 11", groups = "API")
	@Epic("NSS v1.2")
	@Feature("REST API Test")
	@Story("User Story: POS UI REST API Invocation")
	@Severity(SeverityLevel.TRIVIAL)
	public void getParamValid1() {
		pMap.put("ID", "12");
		api.getResponseWithPathParameters("/storemgmt/v1/store/{ID}", pMap);
		api.saveResponse("E:\\Automation_Framework\\TestAutomation\\TestScripts\\Resources\\Output\\Store12.xml",
				"xml");
		pMap.clear();
	}

	@Test(description = "RMA API Test 12", groups = "API")
	@Epic("NSS v1.7")
	@Feature("REST API Test")
	@Story("User Story: POS UI REST API Invocation")
	@Severity(SeverityLevel.NORMAL)
	public void getParamValid2() {
		pMap.put("ID", "12");
		api.getResponseWithPathParameters("/storemgmt/v1/store/{ID}", pMap);
		api.saveResponse("E:\\Automation_Framework\\TestAutomation\\TestScripts\\Resources\\Output\\Store12.html",
				"html");
		pMap.clear();
	}

	@Test(description = "RMA API Test 13", groups = "API")
	@Epic("NSS v1.2")
	@Feature("REST API Test")
	@Story("User Story: POS UI REST API Invocation")
	@Severity(SeverityLevel.MINOR)
	public void getParamValid3() {
		pMap.put("ID", "12");
		api.getResponseWithPathParameters("/storemgmt/v1/store/{ID}", pMap);
		api.saveResponse("E:\\Automation_Framework\\TestAutomation\\TestScripts\\Resources\\Output\\Store12.json",
				"json");
		pMap.clear();
	}

	@Test(description = "RMA API Test 14", groups = "API")
	@Epic("NSS v2.4")
	@Feature("REST API Test")
	@Story("User Story: POS UI REST API Invocation")
	@Severity(SeverityLevel.CRITICAL)
	public void getQueryParamOne() {
		qMap.put("Session", "TestUserSession");
		api.getResponseWithQueryParameters("/storemgmt/v1/stores", qMap);
		qMap.clear();
	}

	@Test(description = "RMA API Test 15", groups = "API")
	@Epic("NSS v1.7")
	@Feature("REST API Test")
	@Story("User Story: POS UI REST API Invocation")
	@Severity(SeverityLevel.CRITICAL)
	public void getQueryParamTwo() {
		qMap.put("UserID", "sumith.kv");
		qMap.put("Password", "Apollo@123");
		api.getResponseWithQueryParameters("/storemgmt/v1/stores", qMap);
	}

}
