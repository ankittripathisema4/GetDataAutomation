package com.sema4.getdata.fhirparser.service;

import javax.annotation.PostConstruct;

import org.hl7.fhir.dstu3.model.Bundle;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.parser.StrictErrorHandler;

@Service
public class ParserService {

	@Autowired
	RestClientService restClientService;
	
	private IParser parser;
	
	@PostConstruct
	private void initParser() {
	    parser = FhirContext.forDstu3().newJsonParser();
	    //parser.setParserErrorHandler(new StrictErrorHandler());
	}
	
	public Bundle parseResponse(String url){
		JSONObject resp = restClientService.getResponse(url);
		return parser.parseResource(Bundle.class, resp.toString());
	}
}
