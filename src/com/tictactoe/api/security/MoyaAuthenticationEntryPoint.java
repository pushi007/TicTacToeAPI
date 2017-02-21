package com.tictactoe.api.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.tictactoe.api.exception.MoyaErrorResponse;
import com.tictactoe.api.exception.MoyaResponseCreator;

/**
 * Authentication entry point for REST services
 */

@Component
public final class MoyaAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@Autowired
	MoyaResponseCreator moyaResponseCreator;
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authenticationException) throws IOException {
		//response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");

		List<String> statusAndCode = moyaResponseCreator.getResponseCode(authenticationException.getMessage());
		response.setContentType("application/json");
		response.setStatus(Integer.parseInt(statusAndCode.get(0).replace("SC", "")));
		response.getOutputStream()
				.println(moyaResponseCreator
						.getMoyaJsonResponse(new MoyaErrorResponse(statusAndCode.get(0), statusAndCode.get(1),
								statusAndCode.get(2), statusAndCode.get(3))));
	
	}
}
