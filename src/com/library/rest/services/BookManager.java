package com.library.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.simple.JSONObject;


import com.library.book.model.BookRequest;
import com.library.book.model.BookResponse;

@Consumes("application/json")
@Produces("application/json") //http://localhost:8080/Library/services/BookManager/
public interface BookManager
{
	@POST
	@Path("/search/")
	public BookResponse search(BookRequest request);
	
	@POST
	@Path("/getBook/")
	public String getBook(JSONObject request);
	
	@POST
	@Path("/addBook/")
	public BookResponse addBook(BookRequest request);
}
