package com.tictactoe.api.endpoint.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.client.RestTemplate;

import com.tictactoe.api.constants.Constant;
import com.tictactoe.api.endpoint.Connectors;
import com.tictactoe.api.endpoint.MoyaEndpoint;
import com.tictactoe.api.exception.MoyaErrorResponse;
import com.tictactoe.api.exception.MoyaGenericException;
import com.tictactoe.api.exception.MoyaResponseCreator;
import com.tictactoe.api.request.GameRequest;
import com.tictactoe.api.service.GameService;
import com.tictactoe.api.util.AesEncrytption;
import com.tictactoe.api.util.MoyaFactory;

public class MoyaEndpointImpl extends Connectors implements MoyaEndpoint, ApplicationContextAware {

	@Autowired
	AesEncrytption aesEncrytption;

	@Autowired
	MoyaErrorResponse moyaErrorResponse;

	@Autowired
	Properties messages;

	@Autowired
	GameService userService;

	@Autowired
	MoyaFactory moyaFactory;

	Log logger = MoyaFactory.getLogger(getClass());

	private ApplicationContext applicationContext;

	@Override
	public Response getPing() {
		JSONObject jsonObject = new JSONObject();
		String jsonResponse = null;
		try {
			// LinkedHashMap<Object, Object> responselist = getEndpoint("", "");
			jsonObject.put("status", "SUCCESS");
			ObjectMapper objectMapper = new ObjectMapper();
			jsonResponse = objectMapper.writeValueAsString(jsonObject.toString());

		} catch (Exception e) {

			moyaFactory.logException(e, "MoyaEndpoint", "Ping");
			MoyaGenericException MoyaGenericException = getGenericExceptionInstance();
			MoyaGenericException.setMoyaResponseCreator(getMoyaResponseCreatorInstance());
			MoyaGenericException.throwMoyaGenericException(Constant.INTERNAL_SERVER_ERROR.getValue(),
					Constant.API_ERROR_MESSAGE.getValue());
		}
		return Response.ok(jsonResponse).build();
	}

	@Override
	public Response getToken() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String jsonResponse = null;
		try {
			// com.moya.api.entity.User userDetail =
			// userService.findByUsername(user.getUsername());
			List<Object> list = null;
			// UserToken userToken = null;
			// if (userDetail != null) {
			// String userId = userDetail.getId();
			// userToken = userTokenService.save(userId, user.getUsername());
			list = new ArrayList<Object>();
			StringBuilder key = new StringBuilder();
			// key.append(userToken.getId()).append(":").append(System.currentTimeMillis());
			String encodedToken = Base64.encodeBase64String(aesEncrytption.encrypt(key.toString()).getBytes());
			list.add(encodedToken);
			// }
			// GenerateTokenResponse generateTokenResponse = new
			// GenerateTokenResponse();
			// generateTokenResponse = generateTokenResponse.build(list,
			// "SUCCESS");
			ObjectMapper objectMapper = new ObjectMapper();
			// jsonResponse =
			// objectMapper.writeValueAsString(generateTokenResponse);
		} catch (Exception e) {
			moyaFactory.logException(e, "MoyaEndpoint", "GetToken");
			MoyaGenericException MoyaGenericException = getGenericExceptionInstance();
			MoyaGenericException.setMoyaResponseCreator(getMoyaResponseCreatorInstance());
			MoyaGenericException.throwMoyaGenericException(Constant.INTERNAL_SERVER_ERROR.getValue(),
					Constant.API_ERROR_MESSAGE.getValue());
		}
		return Response.ok(jsonResponse).build();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public MoyaGenericException getGenericExceptionInstance() {
		return applicationContext.getBean(MoyaGenericException.class);
	}

	public MoyaResponseCreator getMoyaResponseCreatorInstance() {
		return applicationContext.getBean(MoyaResponseCreator.class);
	}

	@SuppressWarnings("unused")
	private User getLoggedInUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}

	private void BadRequestException(String statusCode, String statusMessage) {
		MoyaGenericException restroGenericException = getGenericExceptionInstance();
		restroGenericException.setMoyaResponseCreator(getMoyaResponseCreatorInstance());
		restroGenericException.throwMoyaGenericException(statusCode, statusMessage);
	}

	@Override
	public Response getGameState(GameRequest gameRequest) {

		Object res = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

			// String url = myGovAPIRequest.getUrl() +
			// messages.getProperty(Constant.API_KEY.getValue());

			// res =
			// restTemplate.getForObject(UriComponentsBuilder.fromHttpUrl(url).toUriString(),
			// String.class);

		} catch (Exception e) {
			e.printStackTrace();
			moyaFactory.logException(e, "MoyaEndpoint", "MyGovAPICall");
		}
		return Response.ok(res.toString()).build();
	}

}
