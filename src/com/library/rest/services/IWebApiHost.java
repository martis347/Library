package com.library.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.simple.JSONObject;


import com.library.book.model.GetBookRequest;
import com.library.book.model.GetBookResponse;

@Consumes("application/json")
@Produces("application/json") //http://localhost:8080/Library/services/BookManager/
public interface IWebApiHost
{
	@POST
	@Path("/search/")
	public String search(JSONObject request);
	
	@POST
	@Path("/getBook/")
	public String getBook(JSONObject request);
	
	@POST
	@Path("/addBook/")
	public String addBook(JSONObject request);
}
