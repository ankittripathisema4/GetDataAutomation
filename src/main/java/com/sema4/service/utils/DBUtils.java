package com.sema4.service.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

public class DBUtils {
	
	public static Connection con;
	
	public static Connection getConnection(String dbUrl, String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, userName, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 
	 * @param environment dev, stage
	 * @param schema InitiatorService, PatientDataService, IntegrationService, CCDService
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public static Statement getStatementCreateDBConnection(String environment, String schema) {
		
		Statement statement = null;
		try {
			String dbServer = Utils.getProperty("gd-" + environment.toLowerCase() + "CloudSqlServer");
			String dbSchema = Utils.getProperty("gd-" + environment.toLowerCase() + "CloudSql"+schema+"Schema");
			String username = Utils.getProperty("gd-" + environment.toLowerCase() + "CloudSqlUserName");
			String password = Utils.getProperty("gd-" + environment.toLowerCase() + "CloudSqlPassword");
		
			statement = getConnection(dbServer+dbSchema,username,password).createStatement();
//			System.out.println(dbServer+"/"+dbSchema+","+username+","+password);
//			statement = getConnection("jdbc:mysql://127.0.0.1:3307/gd_initiator_service","root","root").createStatement();
		} catch (MySQLSyntaxErrorException e) {
			System.out.println("schema name is incorrect: "+schema);
			
		} catch (IOException e) {
			System.out.println("");
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		return statement;
	}
	
	public static void closeConnection(Connection dbConnection) {
		try {
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	

}
