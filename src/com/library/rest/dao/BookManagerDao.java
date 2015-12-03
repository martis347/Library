package com.library.rest.dao;

import java.util.List;
import com.library.book.model.Book;
import com.library.book.model.BookRequest;
import com.library.book.model.BookResponse;

public interface BookManagerDao
{
	public BookResponse search(BookRequest request);
	
	public BookResponse getBook(BookRequest request);
	
	public BookResponse addBook(BookRequest request);
}
