package com.tictactoe.api.exception;

import java.io.Serializable;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class MoyaException extends WebApplicationException implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1667892184951916585L;

	public MoyaException(String message, MoyaResponseCreator restroResponseCreator) {
		super(Response.status(restroResponseCreator.getStatusCode(message)).entity(message).type(MediaType.APPLICATION_JSON).build());
	}
	
	private MoyaException(){
		
	}
}