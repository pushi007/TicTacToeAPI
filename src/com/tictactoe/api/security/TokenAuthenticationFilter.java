package com.tictactoe.api.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.tictactoe.api.constants.Constant;
import com.tictactoe.api.exception.MoyaErrorResponse;
import com.tictactoe.api.exception.MoyaResponseCreator;
import com.tictactoe.api.service.GameService;
import com.tictactoe.api.util.AesEncrytption;
import com.tictactoe.api.util.MoyaFactory;
import com.tictactoe.api.util.SHA1Encryption;

public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	private final String LOGIN = "token";

	@Autowired
	AesEncrytption aesEncrytption;

	@Autowired
	MoyaResponseCreator moyaResponseCreator;

	@Autowired
	private GameService userService;

	@Autowired
	Properties messages;

	Log logger = MoyaFactory.getLogger(getClass());

	public TokenAuthenticationFilter(String defaultFilterProcessesUrl) {
		super(defaultFilterProcessesUrl);
		super.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(defaultFilterProcessesUrl));
	}

	@Override
	protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {

		return true;
	}

	/**
	 * Attempt to authenticate request
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		String token = null;
		AbstractAuthenticationToken userAuthenticationToken = null;
		if (request.getRequestURI().toLowerCase().contains(LOGIN)) {
			token = request.getHeader(Constant.BASIC_AUTHENTICATION_HEADER.getValue());
			if (token != null) {
				userAuthenticationToken = authUserByTokenTypeBasic(token);
				if (userAuthenticationToken == null) {
					throw new AuthenticationServiceException(Constant.TOKEN_INVALID.getValue());
				}
			} else {
				throw new AuthenticationServiceException(Constant.TOKEN_MISSING.getValue());
			}
		} else {
			token = request.getHeader(Constant.TOKEN_AUTHENTICATION_HEADER.getValue());
			if (token != null) {
				String decryptedToken;
				try {
					token = new String(Base64.decodeBase64(token));
					decryptedToken = new String(aesEncrytption.decrypt(token));
					userAuthenticationToken = authUserByTokenTypeX(decryptedToken);
					if (userAuthenticationToken == null) {
						throw new AuthenticationServiceException(Constant.TOKEN_INVALID.getValue());
					}

				} catch (Exception e) {
					e.printStackTrace();

					throw new AuthenticationServiceException(Constant.TOKEN_INVALID.getValue());
				}
			} else {
				throw new AuthenticationServiceException(Constant.TOKEN_MISSING.getValue());
			}
		}
		return userAuthenticationToken;
	}

	/**
	 * authenticate the user based on token : BASIC_AUTHENTICATION_HEADER
	 * 
	 * @return
	 */

	private AbstractAuthenticationToken authUserByTokenTypeBasic(String token) {
		if (StringUtils.isBlank(token)) {
			return null;
		}
		String userDetails[] = getUserDeatilsFromToken(token);
		if (userDetails.length == 0) {
			return null;
		}
		String username = userDetails[0];
		String userpass = userDetails[1];
		if (StringUtils.isNotBlank(username)) {

			if (authenticateUserCredentials(username, userpass)) {
				org.springframework.security.core.userdetails.User principal = new org.springframework.security.core.userdetails.User(
						username, userpass, true, true, true, true, getGrantedAuthorities(username));
				AbstractAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(principal, userpass,
						principal.getAuthorities());
				return authToken;
			} else {
				throw new AuthenticationServiceException(Constant.UNAUTHENTICATED.getValue());
			}

		}
		return null;
	}

	/**
	 * authenticate the user based on token : TOKEN_AUTHENTICATION_HEADER
	 * 
	 * @return
	 * @throws JSONException
	 * @throws RestroException
	 */

	private AbstractAuthenticationToken authUserByTokenTypeX(String token) throws JSONException {
		String username = "praveenpal33@gmail.com";
		String userpass = "admin#123";

		if (StringUtils.isNotBlank(username)) {

			if (authenticateUserCredentials(username, userpass)) {
				boolean credentialStatus = true;

				org.springframework.security.core.userdetails.User principal = new org.springframework.security.core.userdetails.User(
						username, userpass, true, true, true, credentialStatus, getGrantedAuthorities(username));
				AbstractAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(principal, userpass,
						principal.getAuthorities());
				return authToken;

			} else {
				throw new AuthenticationServiceException(Constant.UNAUTHENTICATED.getValue());
			}

		}
		return null;
	}

	private List<GrantedAuthority> getGrantedAuthorities(String username) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

		return authorities;
	}

	private boolean authenticateUserCredentials(String username, String userpass) {
		try {
			if ("praveenpal33@gmail.com".equals(username) && "admin#123".equals(userpass)) {
				return true;
			}
		} catch (Exception e) {
			throw new AuthenticationServiceException(Constant.INTERNAL_SERVER_ERROR.getValue());
		}
		return false;
	}

	boolean i = true;

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		response.setHeader("Access-Control-Allow-Origin", messages.getProperty(Constant.ALLOW_ORIGINS.getValue()));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "-1");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Accept, X-Auth-Token, Authorization, X-Requested-With");

		if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
			chain.doFilter(new RequestWrapper(request), res);
		} else {
			super.doFilter(new RequestWrapper(request), res, chain);
		}

	}

	private String[] getUserDeatilsFromToken(String token) {
		if (token.startsWith("Basic ") || token.startsWith("BASIC ")) {
			token = token.replaceFirst("Basic ", "");
		}
		byte[] valueDecoded = Base64.decodeBase64(token.getBytes());
		String userDetails[] = new String(valueDecoded).split(":");
		return userDetails;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		// As this authentication is in HTTP header, after success we need to
		// continue the request normally
		// and return the response as if the resource was not secured at all
		chain.doFilter(request, response);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authenticationException) throws IOException, ServletException {
		List<String> statusAndCode = moyaResponseCreator.getResponseCode(authenticationException.getMessage());
		response.setContentType("application/json");
		response.setStatus(Integer.parseInt(statusAndCode.get(0).replace("SC", "")));
		response.getOutputStream().println(moyaResponseCreator.getMoyaJsonResponse(new MoyaErrorResponse()));
	}

}