package com.library.rest.dao;

import java.util.List;
import com.library.book.model.Book;

public interface BookManagerDao
{
	public Book fetchBookById(Integer id);

	public List<Book> fetchAllBooks();

	public void insertBook(Book book);

	public void updateBook(Book book);

	public void deleteBook(Book book);
}
