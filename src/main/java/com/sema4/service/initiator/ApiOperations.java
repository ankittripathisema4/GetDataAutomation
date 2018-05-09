package com.sema4.service.initiator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
//import com.sema4.service.utils.Utils;
import com.sema4.service.utils.Utils;
import com.sema4.service.utils.APIUtils;

import io.swagger.client.ApiException;
import io.swagger.client.model.PortalResponse;
import io.swagger.client.model.PortalUserStatus;

public class ApiOperations {

	
//	public String getAuthToken() throws ApiException {
//		PatientTokenApi patientTokenApi = new PatientTokenApi();
//		String token = patientTokenApi.token("Basic Z2RhcGl2MTpnZGFwaXYx").getAUTHTOKEN();
//		
//		return token;
//	}
	
	public PortalUserStatus getInitiatorServiceAPIResponse(String portalUserId) throws IOException {
		String urlString = MessageFormat.format(Utils.getProperty("initiatorService-URL"),portalUserId);
		System.out.println(urlString);
		URL url = new URL(urlString);
		HashMap<String, String> requestProperties = new HashMap<String, String>();
		requestProperties.put("AUTH-TOKEN", getInitiatorServiceToken());
		char[] response = APIUtils.getGETAPIResponseText(url, requestProperties);
		System.out.println(response);
		
		String s=new String(response);
		
		String res2="{\"portal_id\":\"portalTEST9\",\"ccd_link\":\"gs://gd-ccd-dev/ccd_8a9c87b26261986901626c6c11950004_1522237566237.pdf\",\"ccd_status\":\"completed\",\"ccd_last_updated\":\"2018-03-28T11:47:17Z\",\"order_info\":[{\"provider_name\":\"Mount Sinai\",\"request_status\":\"active\",\"last_updated\":\"2018-03-28T11:44:04Z\"}]}";
		System.out.println(s);
		System.out.println("------");
		System.out.println(response.toString());
		
		
		
		PortalUserStatus portalResponse = new Gson().fromJson(s, PortalUserStatus.class);
		
		
		return portalResponse;
	}
	
	public String getInitiatorServiceToken() throws MalformedURLException, IOException {
		HashMap<String, String> requestProperties = new HashMap<String, String>();
		requestProperties.put("Authorization", Utils.getProperty("initiatorService-authorization"));
		String token = APIUtils.getHeader(Utils.getProperty("initiatorService-TOKEN"), "GET", requestProperties, "auth-token");
		return token;
	}
	
	public void getPOSTResponseText(String portalUserId, String labNo) throws IOException {
		String urlString = MessageFormat.format(Utils.getProperty("initiatorService-URL"),portalUserId);
		System.out.println(urlString);
		URL url = new URL(urlString);
		HashMap<String, String> requestProperties = new HashMap<String, String>();
		requestProperties.put("AUTH-TOKEN", getInitiatorServiceToken());
		requestProperties.put("Content-Type", "application/json");
		
		String jsonreq = "{\"lab_no\":\"TEST104\",\"npis\" : [\"MSHS\"]}";
		char[] response = APIUtils.getPOSTResponseText(url, requestProperties, jsonreq.toCharArray());
		System.out.println(response);
		
		
	}
	
	
}
