package com.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection con;

	public void getDBConnection(String url,String username,String password) {
		try {
			
			Driver driver= new Driver();
			
			DriverManager.registerDriver(driver);
			Connection con = DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		}
		
		public void getDBConnection() {
			try {
				
				Driver driver= new Driver();
				
				DriverManager.registerDriver(driver);
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ninza","root","root");
				
			} catch (Exception e) {
				System.out.println(e);
			}
	}
	
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result=null;
		try {
		Statement stat = con.createStatement();
	  result = stat.executeQuery(query);
	}catch(Exception e) {
	}
		return result;
	}
	
	public int executeNonSelectQuery(String query) {
		int result=0;
		try {
			Statement stat = con.createStatement();
			 result = stat.executeUpdate(query);
		} catch (Exception e) {
			
		}
		return result;
	}
	
	public void closeDBConnection() {
		try {
			con.close();
		} catch (Exception e) {
			
		}
	}
		
}

