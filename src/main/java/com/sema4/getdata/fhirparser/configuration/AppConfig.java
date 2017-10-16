package com.sema4.getdata.fhirparser.configuration;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix="req-helpers")
@Component
@Validated
public class AppConfig {
	
	@NotNull
	private String authorization;
	
	@NotNull
	private String clientId;
	
	@NotNull
	private String clientSecret;

	private String accept;
	
	@NotNull
	private String patientUrl;
	
	@NotNull
	private String observationUrl;
	
	@NotNull
	private String conditionUrl;
	
	public HttpHeaders getRequestHeaders(){
		HttpHeaders headerMap = new HttpHeaders();
		headerMap.add("Authorization", this.authorization);
		headerMap.add("client_id", this.clientId);
		headerMap.add("client_secret", this.clientSecret);
		headerMap.add("accept", this.accept);
		return headerMap;
	}
	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}
	public String getPatientUrl() {
		return patientUrl;
	}
	public void setPatientUrl(String parientUrl) {
		this.patientUrl = parientUrl;
	}
	public String getObservationUrl() {
		return observationUrl;
	}
	public void setObservationUrl(String observationUrl) {
		this.observationUrl = observationUrl;
	}
	public String getConditionUrl() {
		return conditionUrl;
	}
	public void setConditionUrl(String conditionUrl) {
		this.conditionUrl = conditionUrl;
	}
	
}
