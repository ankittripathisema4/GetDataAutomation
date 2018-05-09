package com.sema4.service.tests;

import org.hl7.fhir.dstu3.model.Bundle;
import org.testng.annotations.Test;

import com.sema4.getdata.fhirparser.configuration.AppConfig;
import com.sema4.getdata.fhirparser.service.ParserService;

public class NewTest {
  @Test
  public void f() {
	  System.out.println("ankkit..");
//	  Bundle bundle = (new ParserService()).parseResponse((new AppConfig()).getEndpoints().getPatient());
//	  System.out.println(bundle);
	  System.out.println("*****");
  }
}
