package com.library.book.model;


public class BookResponse
{
	private Book book;
	private String message;
	
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
}
