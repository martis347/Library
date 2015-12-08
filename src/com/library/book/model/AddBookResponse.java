package com.library.book.model;

import org.apache.log4j.Logger;

public class AddBookResponse implements IBookResponse {

	private String message;
	private static final Logger logger = Logger.getLogger(AddBookResponse.class.getName());
	
	public void setMessage(String message)
	{
		this.message = message;
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
