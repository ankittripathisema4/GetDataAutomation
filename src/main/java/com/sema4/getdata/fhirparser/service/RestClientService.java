package com.sema4.getdata.fhirparser.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sema4.getdata.fhirparser.configuration.AppConfig;

@Service
public class RestClientService {

	@Autowired
	private AppConfig appConfig;
	
	public JSONObject getResponse(String url) {
		System.out.println("########### Getting Response ########### " +url);
		return getJsonResponse(url);
	}
	
	private JSONObject getJsonResponse(String url){
		RestTemplate restTemplate = new RestTemplate();	
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		HttpEntity<Object> request = new HttpEntity<Object>(Object.class, appConfig.getRequestHeaders());

		ResponseEntity<JSONObject> results = restTemplate.exchange(url, HttpMethod.GET, request,
				new ParameterizedTypeReference<JSONObject>() {
				});

		JSONObject response = results.getBody();

		return response;
	}
}
