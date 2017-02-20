package com.moya.api.endpoint;

import java.util.LinkedHashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public abstract class Connectors {

	public LinkedHashMap<Object, Object> getEndpoint(String url, Object object, HttpEntity<String> httpEntity,
			HttpMethod method) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		LinkedHashMap<Object, Object> responselist = null;
		if (object != null) {
			responselist = restTemplate.postForObject(url, object, LinkedHashMap.class);
		} else if (httpEntity != null && method != null) {
			responselist = restTemplate.exchange(url, method, httpEntity, LinkedHashMap.class).getBody();

		} else if (httpEntity != null) {
			responselist = restTemplate.postForEntity(url, httpEntity, LinkedHashMap.class).getBody();
		} else {
			responselist = restTemplate.getForObject(url, LinkedHashMap.class);
		}
		return responselist;
	}
}
