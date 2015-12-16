package com.library.book.model;

import org.apache.log4j.Logger;

public class UpdateBookResponse implements IResponse{

	private String message;
	private Book book;
	private static final Logger logger = Logger.getLogger(AddBookResponse.class.getName());
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public void setBook(Book book)
	{
		this.book = book;
		if(book == null)
		{
			this.message = "No book found to update";
		}
		else if(book != null)
		{
			this.message = "Successfully updated a book!";
		}
	}
	
	public void onError(String message)
	{
		this.message = message;
		logger.warn(message); //Predicted error, log as warning
	}
	public void onError(String message, Exception e)
	{
		this.message = message;
		logger.error("Unexpected error has occured", e);
	}
}
