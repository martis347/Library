package com.library.rest.dao.impl;

import com.library.rest.dao.BookManagerDao;

import org.springframework.beans.factory.annotation.Value;

import com.library.book.model.BookRequest;
import com.library.book.model.BookResponse;

public class BookManagerMemoryDao implements BookManagerDao
{
	public String databaseName;
	
	public void setDatabaseName(String databaseNam)
	{
		databaseName = databaseNam;
		System.out.println(databaseName);
	}
	
	public String getDatabaseName()
	{
		return databaseName;
	}
	
	public BookResponse search(BookRequest request)
	{
		return new BookResponse();
	}
	
	public String getBook(String request)
	{
		return getDatabaseName();
	}

	public String insertBook(String request)
	{
		return request;
	}
	
	
}
