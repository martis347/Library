package com.library.rest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.library.rest.dao.BookManagerDao;
import com.library.book.model.Book;

public class BookManagerMemoryDao implements BookManagerDao
{
	private int nextBookId = 0;

	List<Book> books = new ArrayList<Book>();

	public Book fetchBookById(Integer id)
	{
		for (Book book : books)
		{
			if (book.getId() == id)
			{
				return book;
			}
		}

		throw new RuntimeException("Book Not Found: " + id);
	}

	public List<Book> fetchAllBooks()
	{
		return books;
	}

	public void insertBook(Book book)
	{
		book.setId(nextBookId++);
		books.add(book);
	}

	public void updateBook(Book book)
	{
		Book editBook = fetchBookById(book.getId());

		editBook.setBirthDate(book.getBirthDate());
		editBook.setCity(book.getCity());
		editBook.setEmail(book.getEmail());
		editBook.setName(book.getName());
		editBook.setState(book.getState());
	}

	public void deleteBook(Book book)
	{
		Book delBook = fetchBookById(book.getId());
		books.remove(delBook);
	}

}
