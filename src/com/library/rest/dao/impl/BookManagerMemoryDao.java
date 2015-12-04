package com.library.rest.dao.impl;

import com.library.rest.dao.BookManagerDao;
import com.library.sql.dao.impl.SQLManager;
import com.library.book.model.Book;
import com.library.book.model.BookRequest;
import com.library.book.model.BookResponse;

public class BookManagerMemoryDao implements BookManagerDao
{
	private SQLManager sqlManager;
	public void setSqlManager(SQLManager sqlManager)
	{
		this.sqlManager = sqlManager;
	}
	
	public BookResponse search(BookRequest request)
	{
		return new BookResponse();
	}
	
	public Book getBook(BookRequest request) throws Exception
	{
		Book book = null;
		
		if(request.getName() != null)
		{
			book = sqlManager.getBookByName(request.getName());
		}
		if(book == null && request.getAuthor() != null )
		{
			//book = sqlManager.getBookByAuthor(request.getName());
		}
		if (book == null)
		{
			System.out.println("No book found for given request");
		}
		
		return book;
	}

	public String insertBook(BookRequest request)
	{
		return null;
	}
}
