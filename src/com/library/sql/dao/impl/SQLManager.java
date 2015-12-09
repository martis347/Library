package com.library.sql.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.library.book.model.AddBookRequest;
import com.library.book.model.Book;
import com.library.book.model.GetBookResponse;

public class SQLManager {
	private String connectionString;
	private String username;
	private String password;
	private static final Logger logger = Logger.getLogger(GetBookResponse.class.getName());
	
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
        	logger.error("Error opening connection", e);
        }
	}
	public void closeConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			logger.error("Error closing connection", e);
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
			closeConnection();
			logger.error("An error has occured while getting book from database", e);
		}
		
		return book;
	}
	
	public String addBook(AddBookRequest request)
	{
		openConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO dbo.Book VALUES(?, ?, ? ,?) SET NOCOUNT ON"); //SET NOCOUNT ON is required to avoid 'the statement did not return a result set' exception
			statement.setString(1, request.getName());
			statement.setString(2, request.getAuthor());
			statement.setObject(3, request.getEntryDate());
			statement.setString(4, request.getTakenBy());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			closeConnection();
			logger.error("An error has occured while a adding book to database", e);
			return "An error has occured while a adding book to database";
		}
		return "Book successfully added";
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

	public ArrayList<String> searchByName(String name) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("FF");
		list.add("LOL");
		list.add("sdfsdfdsf");
		list.add("sdfsdfsdf");
		return list;
	}

}
