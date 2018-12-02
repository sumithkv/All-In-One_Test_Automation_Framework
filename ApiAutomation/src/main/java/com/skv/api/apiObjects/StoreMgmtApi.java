package com.skv.api.apiObjects;

import java.util.HashMap;

import com.skv.api.utils.AbstractApi;

import io.restassured.response.Response;

public class StoreMgmtApi extends AbstractApi {

	@Override
	public void setSslConfig() throws Exception {
		// TODO Auto-generated method stub
		super.setSslConfig();
	}

	@Override
	public void skipSslConfig() throws Exception {
		// TODO Auto-generated method stub
		super.skipSslConfig();
	}

	@Override
	public void setBaseURL() {
		// TODO Auto-generated method stub
		super.setBaseURL();
	}

	@Override
	public Response getResponse(String path) {
		// TODO Auto-generated method stub
		return super.getResponse(path);
	}

	@Override
	public int getResponseCode(String path) {
		// TODO Auto-generated method stub
		return super.getResponseCode(path);
	}

	@Override
	public String getResponseMessage(String path) {
		// TODO Auto-generated method stub
		return super.getResponseMessage(path);
	}

	@Override
	public void verifyResponseCode(int statusCode) {
		// TODO Auto-generated method stub
		super.verifyResponseCode(statusCode);
	}

	@Override
	public void verifyResponseMessage(String statusMessage) {
		// TODO Auto-generated method stub
		super.verifyResponseMessage(statusMessage);
	}

	@Override
	public Response postRequest(String path, String file, String contentType) {
		// TODO Auto-generated method stub
		return super.postRequest(path, file, contentType);
	}

	@Override
	public String getHeaderValue(String header) {
		// TODO Auto-generated method stub
		return super.getHeaderValue(header);
	}

	@Override
	public void verifyHeaderValue(String header, String value) {
		// TODO Auto-generated method stub
		super.verifyHeaderValue(header, value);
	}

	@Override
	public void setHeader(String header, String value) {
		// TODO Auto-generated method stub
		super.setHeader(header, value);
	}

	@Override
	public Response getResponseWithPathParameters(String path, HashMap<String, String> paramMap) {
		// TODO Auto-generated method stub
		return super.getResponseWithPathParameters(path, paramMap);
	}

	@Override
	public Response getResponseWithQueryParameters(String path, HashMap<String, String> queryParam) {
		// TODO Auto-generated method stub
		return super.getResponseWithQueryParameters(path, queryParam);
	}

	@Override
	public void saveResponse(String filePath, String fileType) {
		// TODO Auto-generated method stub
		super.saveResponse(filePath, fileType);
	}

}
