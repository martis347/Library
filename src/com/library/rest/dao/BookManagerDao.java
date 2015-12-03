package com.library.rest.dao;

import com.library.book.model.BookRequest;
import com.library.book.model.BookResponse;

public interface BookManagerDao
{
	public BookResponse search(BookRequest request);
	
	public String getBook(String request);
	
	public String insertBook(String request);
}
