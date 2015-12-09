package com.library.rest.services.impl;

import com.library.rest.services.IWebApiHost;
import com.library.book.model.AddBookResponse;
import com.library.book.model.GetBookResponse;
import com.library.book.model.SearchResponse;
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
		handler = (IHandler) context.getBean("searchHandler");
		SearchResponse response = (SearchResponse) handler.Handle(request);
		
		Gson gson = new Gson();
		return gson.toJson(response);
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
