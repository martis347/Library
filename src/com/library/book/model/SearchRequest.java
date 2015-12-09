package com.library.book.model;

public class SearchRequest implements IRequest{
	
	private String name;
	private String author;
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}	
	public String getAuthor()
	{
		return author;
	}
	
	public String getValue(String value)
	{
		if(value == "name")
			return name;
		else if(value == "author")
			return author;
		
		return null;
	}
}
