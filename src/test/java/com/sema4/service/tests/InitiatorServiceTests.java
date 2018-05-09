package com.sema4.service.tests;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.sema4.service.initiator.ApiOperations;
import com.sema4.service.utils.DBUtils;
import com.sema4.service.utils.Utils;

import io.swagger.client.ApiException;
import io.swagger.client.api.PatientStatusControllerApi;
import io.swagger.client.model.PortalResponse;
import io.swagger.client.model.PortalUserStatus;


public class InitiatorServiceTests extends com.sema4.service.initiator.ApiOperations{

	
	@Test
	public void testCase1() throws ApiException, IOException, SQLException {
		System.out.println("****abc****");
		
		
		
		
//		Statement statement = DBUtils.getStatementCreateDBConnection("dev","InitiatorService");
//		ResultSet rs = statement.executeQuery("select * from patient;");
		
		ApiOperations operations = new ApiOperations();
//		System.out.println(operations.getInitiatorServiceToken());
//		PortalUserStatus portalUserStatus = operations.getInitiatorServiceAPIResponse("portalTEST9");
//		System.out.println(portalUserStatus.getCcdLink());

//		PatientStatus patientStatus = operations.getInitiatorServiceAPIResponse("portalTEST3");
		
		operations.getPOSTResponseText("PortalTEST1", "TEST104");
		
		System.out.println("****x****");
		
	}
	
	
	
}
