package com.sema4.getdata.fhirparser;

import static org.junit.Assert.assertNotNull;

import org.hl7.fhir.dstu3.model.Bundle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.sema4.getdata.fhirparser.service.ParserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.yml")
public class ParserTests {

	@Autowired
	ParserService parserService;
	
	@Test
	public void checkPatientResponseWorks(){
		Bundle bundle = parserService.parsePatientResponse();
		assertNotNull(bundle);
	}
	
	@Test
	public void checkObservationResponseWorks(){
		Bundle bundle = parserService.parseObservationResponse();
		assertNotNull(bundle);
	}
	
	@Test
	public void checkConditionResponseWorks(){
		Bundle bundle = parserService.parseConditionResponse();
		assertNotNull(bundle);
	}
}
