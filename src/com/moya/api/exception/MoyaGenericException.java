package com.moya.api.exception;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoyaGenericException extends Exception implements Serializable {

	private static final long serialVersionUID = 5173790884249714546L;

	@Autowired
	MoyaResponseCreator moyaResponseCreator;

	public void throwMoyaGenericException(String exceptionCode, String message){
		List<String> statusAndCode = moyaResponseCreator.getResponseCode(exceptionCode);
		throw new MoyaException(moyaResponseCreator
				.getMoyaJsonResponse(new MoyaErrorResponse(statusAndCode.get(0), statusAndCode.get(1),
						statusAndCode.get(2), message)), moyaResponseCreator);
	}
	
	private MoyaGenericException(){
		
	}

}
