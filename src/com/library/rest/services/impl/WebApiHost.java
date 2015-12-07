package com.library.rest.services.impl;

import com.library.rest.services.IWebApiHost;
import com.library.book.model.BookRequest;
import com.library.book.model.BookResponse;
import com.library.handlers.IHandler;
import org.json.simple.JSONObject;
import com.google.gson.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class WebApiHost implements IWebApiHost
{
	IHandler handler;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	
	public BookResponse search(BookRequest request) {
		// TODO Implement metaphone
		return null;
	}
	
	public String getBook(JSONObject request) {
		handler = (IHandler) context.getBean("getHandler");
		BookResponse response = handler.Handle(request);
		
		Gson gson = new Gson();
		return gson.toJson(response);
	}

	public BookResponse addBook(BookRequest request) {
		return null;
	}
}