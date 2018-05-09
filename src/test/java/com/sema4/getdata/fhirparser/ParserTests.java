package com.sema4.getdata.fhirparser;

import static org.junit.Assert.assertNotNull;

import org.hl7.fhir.dstu3.model.Bundle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.sema4.getdata.fhirparser.configuration.AppConfig;
import com.sema4.getdata.fhirparser.service.ParserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.yml")
public class ParserTests {

	@Autowired
	ParserService parserService;

	@Autowired
	AppConfig appConfig;
	
//	@Test
	public void verifyPatient(){
		Bundle bundle = parserService.parseResponse(appConfig.getEndpoints().getPatient());
		assertNotNull(bundle);
	}
	
//	@Test
	public void verifyPatientProblems(){
		Bundle bundle = parserService.parseResponse(appConfig.getEndpoints().getPatientProblems());
		assertNotNull(bundle);
	}
	
//	@Test
	public void verifyPatientLabResults(){
		Bundle bundle = parserService.parseResponse(appConfig.getEndpoints().getPatientLabResults());
		assertNotNull(bundle);
	}
	
//	@Test
	public void verifyPatientVitalSigns(){
		Bundle bundle = parserService.parseResponse(appConfig.getEndpoints().getPatientVitalSigns());
		assertNotNull(bundle);
	}
	
//	@Test
	public void verifyPatientEncounters(){
		Bundle bundle = parserService.parseResponse(appConfig.getEndpoints().getPatientEncounters());
		assertNotNull(bundle);
	}
}
