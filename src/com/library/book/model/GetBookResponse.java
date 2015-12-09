package com.library.book.model;

import org.apache.log4j.Logger;

public class GetBookResponse implements IResponse
{
	private Book book;
	private String message;
	private static final Logger logger = Logger.getLogger(GetBookResponse.class.getName());
	
	public void setBook(Book book)
	{
		this.book = book;
		if(book == null)
		{
			this.message = "No book was found!";
		}
		else if(book != null)
		{
			this.message = "Successfully found a book!";
		}
	}
	public Book getBook()
	{
		return book;
	}
	
	public void onError(String message)
	{
		this.message = message;
		logger.warn(message);
	}
	public void onError(String message, Exception e)
	{
		this.message = message;
		logger.error("Unexpected error has occured", e);
	}
}
