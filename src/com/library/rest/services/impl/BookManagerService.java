package com.library.rest.services.impl;

import com.library.rest.dao.BookManagerDao;
import com.library.rest.services.BookManager;
import com.library.book.model.BookRequest;
import com.library.book.model.BookResponse;

import org.json.simple.JSONObject;
import com.google.gson.*;;

public class BookManagerService implements BookManager
{
	private BookManagerDao bookDao;

	public BookManagerDao getBookDao()
	{
		return bookDao;
	}

	public void setBookDao(BookManagerDao bookDao)
	{
		System.out.println(bookDao);
		this.bookDao = bookDao;
	}
	
	public BookResponse search(BookRequest request) {
		// TODO Implement metaphone
		return null;
	}
	
	public String getBook(JSONObject request) {
		BookResponse resp = new BookResponse();
		resp.message = (String) request.get("message");
		//System.out.println("InsertBook" + bookDao.insertBook("FF") + " getBook " + bookDao.getBook("fdsf"));
		Gson gson = new Gson();
		return gson.toJson(resp);
	}

	public BookResponse addBook(BookRequest request) {
		return null;
	}
}
