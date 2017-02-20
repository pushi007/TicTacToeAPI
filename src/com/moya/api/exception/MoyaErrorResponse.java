package com.moya.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MoyaErrorResponse {
	
	private String statusCode;
	private String status;
	private String statusMessage;
	private String additionalStatusMessage;
	
	public MoyaErrorResponse(){
		
	}
}
