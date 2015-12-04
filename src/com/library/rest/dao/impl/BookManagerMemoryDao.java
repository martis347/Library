package com.library.rest.dao.impl;

import com.library.rest.dao.BookManagerDao;
import com.library.book.model.Book;
import com.library.book.model.BookRequest;
import com.library.book.model.BookResponse;

public class BookManagerMemoryDao implements BookManagerDao
{
	public BookResponse search(BookRequest request)
	{
		return new BookResponse();
	}
	
	public Book getBook(BookRequest request)
	{
		return null;
	}

	public String insertBook(BookRequest request)
	{
		return null;
	}
}
