package com.library.rest.dao;

import com.library.book.model.Book;
import com.library.book.model.BookRequest;
import com.library.book.model.BookResponse;

public interface BookManagerDao
{
	public BookResponse search(BookRequest request);
	
	public Book getBook(BookRequest request);
	
	public String insertBook(BookRequest request);
}
