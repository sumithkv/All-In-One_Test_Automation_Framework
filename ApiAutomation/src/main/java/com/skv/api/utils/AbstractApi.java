package com.skv.api.utils;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyStore;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;

public abstract class AbstractApi {

	final String BaseUrl = "https://10.113.129.9/toshibasystemsmgmt";
	static Response Resp;
	SSLConfig config = null;
	KeyStore keyStore = null;
	File KeyStoreFile = new File("E:\\Automation_Framework\\TestAutomation\\TestScripts\\Resources\\TestData\\truststore.jks");
	String KeyStorePassword = "S1mstest";

	@SuppressWarnings("deprecation")
	protected void setSslConfig() throws Exception {

		try {
			keyStore = KeyStore.getInstance("JKS");
			keyStore.load(new FileInputStream(KeyStoreFile), KeyStorePassword.toCharArray());

		} catch (Exception ex) {
			System.out.println("Error while loading the keystore >>>>>>>>>");
			ex.printStackTrace();
		}

		if (keyStore != null) {

			org.apache.http.conn.ssl.SSLSocketFactory clientAuthFactory = new org.apache.http.conn.ssl.SSLSocketFactory(
					keyStore, KeyStorePassword);

			config = new SSLConfig().with().sslSocketFactory(clientAuthFactory).and().allowAllHostnames();
			RestAssured.config = RestAssured.config().sslConfig(config.relaxedHTTPSValidation("TLS"));
		}
	}

	protected void skipSslConfig() throws Exception {
		RestAssured.config = RestAssured.config().sslConfig(config.relaxedHTTPSValidation("TLS"));
	}

	protected void setBaseURL() {
		try {
			skipSslConfig();
			//setSslConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}
		RestAssured.baseURI = this.BaseUrl;
	}

	protected Response getResponse(String path) {
		setBaseURL();
		return Resp = RestAssured.given().request(Method.GET, path);
	}

	protected int getResponseCode(String path) {
		setBaseURL();
		return RestAssured.given().request(Method.GET, path).getStatusCode();
	}

	protected String getResponseMessage(String path) {
		setBaseURL();
		return RestAssured.given().request(Method.GET, path).getStatusLine();
	}

	protected void verifyResponseCode(int statusCode) {
		assertEquals(statusCode, Resp.getStatusCode());
	}

	protected void verifyResponseMessage(String statusMessage) {
		assertEquals(statusMessage, Resp.getStatusLine());
	}

	protected Response postRequest(String path, String file, String contentType) {
		File inFile = new File(file);
		setBaseURL();

		if (contentType.equalsIgnoreCase("xml")) {
			Resp = RestAssured.given().contentType("application/xml").body(inFile).request(Method.POST, path);
		} else if (contentType.equalsIgnoreCase("json")) {
			Resp = RestAssured.given().contentType("application/json").body(inFile).request(Method.POST, path);
		}

		else {
			System.out.println("Invalid Content Type is Specified");
		}

		return Resp;
	}

	protected String getHeaderValue(String header) {
		return Resp.header(header);
	}

	protected void verifyHeaderValue(String header, String value) {
		assertEquals(value, Resp.header(header));
	}

	protected void setHeader(String header, String value) {
		RestAssured.given().header(header, value);
	}

	protected Response getResponseWithPathParameters(String path, HashMap<String, String> paramMap) {
		setBaseURL();
		return Resp = RestAssured.given().get(path, paramMap);
	}

	protected Response getResponseWithQueryParameters(String path, HashMap<String, String> queryParam) {
		setBaseURL();
		return RestAssured.given().queryParams(queryParam).when().get(path);
	}

	protected void saveResponse(String filePath, String fileType) {
		if (fileType.equalsIgnoreCase("xml")) {

			File f = new File(filePath);
			FileWriter fw = null;
			BufferedWriter bf = null;
			try {
				fw = new FileWriter(f);
				bf = new BufferedWriter(fw);
				bf.write(Resp.body().prettyPrint());
			} catch (Exception E) {
				E.printStackTrace();
			} finally {
				try {
					bf.close();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		} else if (fileType.equalsIgnoreCase("json")) {

			File f = new File(filePath);
			FileWriter fw = null;
			BufferedWriter bf = null;
			try {
				fw = new FileWriter(f);
				bf = new BufferedWriter(fw);
				bf.write(Resp.body().prettyPrint());
			} catch (Exception E) {
				E.printStackTrace();
			} finally {
				try {
					bf.close();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		} else if (fileType.equalsIgnoreCase("html")) {

			File f = new File(filePath);
			FileWriter fw = null;
			BufferedWriter bf = null;
			try {
				fw = new FileWriter(f);
				bf = new BufferedWriter(fw);
				bf.write(Resp.body().prettyPrint());
			} catch (Exception E) {
				E.printStackTrace();
			} finally {
				try {
					bf.close();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		} else {
			System.out.println("Invalid File Type is Specified");
		}
	}

	protected void verifyResponseBodyContains(String testToVerify) {
		assertEquals(true, Resp.getBody().asString().contains(testToVerify));
	}

	protected void getJsonPath(String testToVerify) {
		assertEquals(true, Resp.getBody().asString().contains(testToVerify));
	}
}
