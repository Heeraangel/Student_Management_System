package com.student_management_system.genericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.cj.jdbc.Driver;

public class DataBaseLibrary {
	public Connection connection;
	public Statement statement;
	/**
	 * This method is used to open database connection
	 * @param dbUrl
	 * @param dbUname
	 * @param dbPwd
	 */
	public  void openDBConnection(String dbUrl, String dbUname, String dbPwd)
	{
		Driver driver = null;
		try {
			driver = new Driver();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			DriverManager.registerDriver(driver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			statement=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to fetch data from database
	 * @param query 
	 * @param columnIndex 
	 * @return 
	 */
	public  ArrayList<String> getDataFromDatabase(String query, String columnName)
	{
		ArrayList<String> list=new ArrayList<>();
		ResultSet result = null;
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(result.next())
			{
				try {
					list.add(result.getString(columnName));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * This method is used to validate the data whether it is preasent in the database or not
	 * @param query
	 * @param columnName
	 * @param ExpectedData
	 * @return
	 */
	public  boolean validateDataInDatabase(String query, String columnName, String ExpectedData)
	{
		ArrayList<String> list=getDataFromDatabase(query, columnName);
		boolean flag=false;
		for(String actualData:list)
		{
			if(actualData.equalsIgnoreCase(ExpectedData))
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
	/**
	 * This method is used to store/modify/insert/delete the values to the database or to do DML and DDL actions
	 * @param query
	 */
	public  void setDataFromDatabase(String query)
	{
		int result = 0;
		try {
			result = statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>=1)
			System.out.println("Data entered/modified successfully");
	}
	/**
	 * this method is used to close the database connection
	 */
	public  void closeDBConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
