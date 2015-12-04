package com.library.rest.services.impl;

import com.library.rest.dao.BookManagerDao;
import com.library.rest.services.BookManager;
import com.library.book.model.BookRequest;
import com.library.book.model.BookResponse;
import com.library.converters.JsonConverter;

import org.json.simple.JSONObject;
import com.google.gson.*;;

public class BookManagerService implements BookManager
{
	private BookManagerDao bookDao;

	public void setBookDao(BookManagerDao bookDao)
	{
		this.bookDao = bookDao;
	}
	
	public BookResponse search(BookRequest request) {
		// TODO Implement metaphone
		return null;
	}
	
	public String getBook(JSONObject request) throws Exception {
		BookResponse resp = new BookResponse();
		
		BookRequest bookRequest = JsonConverter.convert(request);
		
		resp.setBook(bookDao.getBook(bookRequest));
		
		Gson gson = new Gson();
		return gson.toJson(resp);
	}

	public BookResponse addBook(BookRequest request) {
		return null;
	}
}
