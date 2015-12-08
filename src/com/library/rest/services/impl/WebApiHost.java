package com.library.rest.services.impl;

import com.library.rest.services.IWebApiHost;
import com.library.book.model.AddBookResponse;
import com.library.book.model.GetBookRequest;
import com.library.book.model.GetBookResponse;
import com.library.handlers.IHandler;
import org.json.simple.JSONObject;
import com.google.gson.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class WebApiHost implements IWebApiHost
{
	IHandler handler;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	
	public String search(JSONObject request) {
		// TODO Implement metaphone
		return null;
	}
	
	public String getBook(JSONObject request) {
		handler = (IHandler) context.getBean("getHandler");
		GetBookResponse response = (GetBookResponse) handler.Handle(request);
		
		Gson gson = new Gson();
		return gson.toJson(response);
	}

	public String addBook(JSONObject request) {
		handler = (IHandler) context.getBean("addHandler");
		AddBookResponse response = (AddBookResponse) handler.Handle(request);
		
		Gson gson = new Gson();
		return gson.toJson(response);
	}
}
