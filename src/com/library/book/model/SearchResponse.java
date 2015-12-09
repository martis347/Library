package com.library.book.model;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class SearchResponse implements IResponse {
	private ArrayList<String> name = new ArrayList<String>();
	private ArrayList<String> author = new ArrayList<String>();
	private String message;
	private static final Logger logger = Logger.getLogger(SearchResponse.class.getName());
	
	public void setName(ArrayList<String> name)
	{
		this.name = name;
	}
	public ArrayList<String> getName()
	{
		return name;
	}
	
	public ArrayList<String> getAuthor()
	{
		return author;
	}
	
	public Boolean isResponseEmpty()
	{
		if(name == null && author == null)
		{
			return true;
		}
		
			
		
		return false;
	}
	
	public void setValue(ArrayList<String> list, String value)
	{
		if(value == "name")
		{
			this.name = list;
		}
		else if(value == "author")
		{
			this.author = list;
		}
		message = "Search has yielded these results";
		
		if(name.isEmpty())
		{
			name = null;
		}
		if(author.isEmpty())
		{
			author = null;
		}
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getMessage()
	{
		return message;
	}
	
	public void onError(String message) {
		this.message = message;
		logger.warn(message);
	}
	public void onError(String message, Exception e) {
		this.message = message;
		logger.warn(message, e);
	}
}
