package com.library.book.model;

import java.sql.Date;

public class AddBookRequest implements IBookRequest{
	private String name;
	private String author;
	private Date entryDate;
	private String takenBy;
	
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
	
	public void setEntryDate(Date entryDate)
	{
		this.entryDate = entryDate;
	}	
	public Date getEntryDate()
	{
		return entryDate;
	}
	
	public void setTakenBy(String takenBy)
	{
		this.takenBy = takenBy;
	}	
	public String getTakenBy()
	{
		return takenBy;
	}
}
