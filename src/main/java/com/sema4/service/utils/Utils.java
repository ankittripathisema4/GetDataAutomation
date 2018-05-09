package com.sema4.service.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {

	static FileInputStream fileInputStream;
	static Properties properties;
	
	public static void loadPropertiesFile() throws IOException {
		File file = new File("src/main/resources/config.properties");
		fileInputStream = new FileInputStream(file);
		properties = new Properties();
		properties.load(fileInputStream);
		fileInputStream.close();
	}
	
	public static String getProperty(String propertyName) throws IOException {
		System.out.println(propertyName);
		loadPropertiesFile();
		return properties.getProperty(propertyName);
	}
	
	
	
	
	
	
	
}
