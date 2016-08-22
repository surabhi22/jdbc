package com.training.utils;

import java.sql.*;
import java.util.Properties;

import oracle.jdbc.driver.DBConversion;

import java.io.*;


public class MySQLConnection {
	
	public static Connection getMyOracleConnection()
	{
		
		Connection con = null;
		try {
			
			Properties props = new Properties();
			
			FileInputStream inStream = new FileInputStream(new File("DbConnection.properties"));
			
			props.load(inStream);
			
			Class.forName(props.getProperty("db.driverClass"));
			
			con = DriverManager.getConnection(props.getProperty("db.driverURL"),props.getProperty("db.userName"),props.getProperty("db.password"));
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
		
	}

}
