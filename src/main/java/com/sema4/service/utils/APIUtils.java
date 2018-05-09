package com.sema4.service.utils;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class APIUtils {

	private static CharArrayWriter writer;

	
	public static char[] getGETAPIResponseText(URL url,HashMap<String, String> requestProperties) {
		HttpURLConnection conn = null;
		writer = new CharArrayWriter();
		try {
//			conn = (HttpURLConnection) url.openConnection();
//			conn.setRequestMethod("GET");
			
//			conn.connect();
			
			conn = createHttpConnection(url, "GET", requestProperties);
//			writer.write(conn.getResponseCode());
			InputStreamReader reader = new InputStreamReader(conn.getInputStream(),"UTF-8");
			int c;
			while((c = reader.read()) != -1) {
				writer.write(c);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			conn.disconnect();
		}
		return writer.toCharArray();
	}
	
	public static HttpURLConnection createHttpConnection(URL url, String requestMethod, HashMap<String,String> requestProperties) {
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(requestMethod);
			for(String key: requestProperties.keySet()) {
				conn.setRequestProperty(key, requestProperties.get(key));
			}
//			conn.setRequestProperty("Authorization", Utils.getProperty("initiatorService-authorization"));
//			conn.setRequestProperty(key, value);
			conn.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 
	 * @param stringUrl
	 * @param requestMethod GET POST DELETE etc
	 * @param requestProperties all the request headers
	 * @param responseHeaderName the name of the response header which is required
	 * @return value of that response header
	 * @throws IOException
	 */
	public static String getHeader(String stringUrl, String requestMethod, HashMap<String,String> requestProperties, String responseHeaderName) throws IOException {
		HashMap<String, String> reqProperties = requestProperties;
		URL url = new URL(stringUrl);
		HttpURLConnection conn = createHttpConnection(url, requestMethod, reqProperties);
//		conn.setRequestProperty("Authorization", Utils.getProperty("initiatorService-authorization"));
		String headerValue = conn.getHeaderField(responseHeaderName);
		
		return headerValue;
	}

	/**
	 * 
	 * 
	 * @param url
	 * @param requestProperties
	 * @param payload
	 * @return
	 */
	public static char[] getPOSTResponseText(URL url, HashMap<String, String> requestProperties, char[] payload) {
		HttpURLConnection conn = null;
		writer = new CharArrayWriter();
		StringBuffer response = new StringBuffer();
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			for(String key: requestProperties.keySet()) {
				conn.setRequestProperty(key, requestProperties.get(key));
			}
			conn.setDoOutput(true);
//			conn.getOutputStream().write(new String(payload).getBytes());;
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.writeBytes(new String(payload));
			wr.flush();
			wr.close();
			
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
//			conn.connect();
			conn.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new String(response).toCharArray();
	}
	
	
	
	
	
	
	
	
	
	
	
}
