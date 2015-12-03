package com.library.rest.services.impl;

import com.library.rest.dao.BookManagerDao;
import com.library.rest.services.BookManager;
import com.library.book.model.BookRequest;
import com.library.book.model.BookResponse;

public class BookManagerService implements BookManager
{
	private BookManagerDao bookDao;

	public BookManagerDao getBookDao()
	{
		return bookDao;
	}

	public void setBookDao(BookManagerDao bookDao)
	{
		this.bookDao = bookDao;
	}

	public BookResponse search(BookRequest request) {
		// TODO Implement metaphone
		return null;
	}

	public BookResponse getBook(BookRequest request) {
		System.out.println(request.Name);
		return null;
	}

	public BookResponse addBook(BookRequest request) {
		
		return null;
	}
	
}
