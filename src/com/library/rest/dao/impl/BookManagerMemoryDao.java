package com.library.rest.dao.impl;

import com.library.rest.dao.BookManagerDao;
import com.library.book.model.BookRequest;
import com.library.book.model.BookResponse;

public class BookManagerMemoryDao implements BookManagerDao
{
	public BookResponse search(BookRequest request)
	{
		return new BookResponse();
	}
	
	public BookResponse getBook(BookRequest request)
	{
		return new BookResponse();
	}
	
	public BookResponse addBook(BookRequest request)
	{
		return new BookResponse();
	}
}
