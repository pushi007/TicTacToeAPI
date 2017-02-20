package com.moya.api.exception;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class MoyaResponseCreator {
	
	@Autowired
	Properties messages;
	
	public List<String> getResponseCode(String exceptionCode){
		List<String> listOfCodes = new LinkedList<String>();
		String statusAndCode[] = exceptionCode.split(":");
		listOfCodes.add(statusAndCode[1]);
		listOfCodes.add(statusAndCode[0]);
		listOfCodes.add(messages.getProperty(statusAndCode[1]));
		listOfCodes.add(messages.getProperty(statusAndCode[1]));
		return listOfCodes;
	}

	public String getMoyaJsonResponse(MoyaErrorResponse restroErrorResponse) {
		ObjectMapper objectMapper = new ObjectMapper();
		String errorResponse = null;
		try {
			errorResponse = objectMapper.writeValueAsString(restroErrorResponse);
		} catch (JsonGenerationException | JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return errorResponse;
	}
	
	public int getStatusCode(String jsonString){
		JSONObject jsonObject;
		int statusCode=0;
		try {
			jsonObject = new JSONObject(jsonString);
			statusCode = Integer.parseInt(jsonObject.getString("statusCode").replaceFirst("SC", ""));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return statusCode;
	}
}
