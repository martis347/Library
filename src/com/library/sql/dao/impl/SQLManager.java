package com.library.sql.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.book.model.Book;

public class SQLManager {
	private String connectionString;
	private String username;
	private String password;
	
	private Connection connection;
	
	public SQLManager(String connectionString, String username, String password)
	{
		this.connectionString = connectionString;
		this.username = username;
		this.password = password;
	}

	public void openConnection()
	{
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        	connection = DriverManager.getConnection(connectionString, username, password);
        } catch (Exception e) {
        	System.out.println("Error opening connection");
            e.printStackTrace();
        }
	}
	public void closeConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error closing connection");
			e.printStackTrace();
		}
	}
	
	public Book getBookByName(String bookName)
	{
		Book book = new Book();
		openConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM dbo.Book WHERE BookName=?");
			statement.setString(1, bookName);
			
			ResultSet result = statement.executeQuery();
			book = mapToBook(result);
		} catch (SQLException e) {
			System.out.println("Error selecting book by name");
			e.printStackTrace();
		}
		closeConnection();
		
		return book;
	}
	
	private Book mapToBook(ResultSet result)
	{
		Book book = new Book();
		try {
			if(!result.next())
			{
				return null;
			}
			
            book.setName(result.getString("BookName"));
            book.setAuthor(result.getString("BookAuthor"));
            book.setEntryDate(result.getDate("EntryDate"));
            book.setTakenBy(result.getString("BookTakenBy"));
		} catch (Exception e) {
			System.out.println("Error mapping book response");
		}
		return book;
	}
}
