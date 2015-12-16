package com.library.book.model;

public class UpdateBookRequest implements IRequest{
	private String oldName;
	private String oldAuthor;
	
	private String newName;
	private String newAuthor;
	
	public void setOldName(String oldName)
	{
		this.oldName = oldName;
	}
	public String getOldName()
	{
		return oldName;
	}
	
	public void setOldAuthor(String oldAuthor)
	{
		this.oldAuthor = oldAuthor;
	}	
	public String getOldAuthor()
	{
		return oldAuthor;
	}
	
	
	public void setNewName(String newName)
	{
		this.newName = newName;
	}
	public String getNewName()
	{
		return newName;
	}
	
	public void setNewAuthor(String newAuthor)
	{
		this.newAuthor = newAuthor;
	}	
	public String getNewAuthor()
	{
		return newAuthor;
	}

}
