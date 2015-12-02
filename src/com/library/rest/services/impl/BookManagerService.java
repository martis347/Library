package com.library.rest.services.impl;

import java.util.Arrays;

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

	public BookResponse fetchBookById(BookRequest request)
	{
		BookResponse response = new BookResponse();

		try
		{
			response.setBooks(Arrays.asList(getBookDao().fetchBookById(request.getBook().getId())));
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setErrorMessage(e.getClass() + ": " + e.getMessage());
		}

		return response;
	}

	public BookResponse fetchAllBooks(BookRequest request)
	{
		BookResponse response = new BookResponse();

		try
		{
			response.setBooks(getBookDao().fetchAllBooks());
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setErrorMessage(e.getClass() + ": " + e.getMessage());
		}

		return response;
	}

	public BookResponse insertBook(BookRequest request)
	{
		BookResponse response = new BookResponse();

		try
		{
			getBookDao().insertBook(request.getBook());
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setErrorMessage(e.getClass() + ": " + e.getMessage());
		}

		return response;
	}

	public BookResponse updateBook(BookRequest request)
	{
		BookResponse response = new BookResponse();

		try
		{
			getBookDao().updateBook(request.getBook());
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setErrorMessage(e.getClass() + ": " + e.getMessage());
		}

		return response;
	}

	public BookResponse deleteBook(BookRequest request)
	{
		BookResponse response = new BookResponse();

		try
		{
			getBookDao().deleteBook(request.getBook());
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setErrorMessage(e.getClass() + ": " + e.getMessage());
		}

		return response;
	}
}
