package com.library.sql.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLManager {
	private String connectionString;
	private String username;
	private String password;
	
	public SQLManager(String connectionString, String username, String password)
	{
		this.connectionString = connectionString;
		this.username = username;
		this.password = password;
	}

	public Connection openConnection()
	{
		Connection connection = null;
        try {
        	connection = DriverManager.getConnection(connectionString, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
	}
}
