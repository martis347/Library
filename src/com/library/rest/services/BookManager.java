package com.library.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.library.book.model.BookRequest;
import com.library.book.model.BookResponse;

@Consumes("application/json")
@Produces("application/json")
public interface BookManager
{
	@POST
	@Path("/fetchBookById/")
	public BookResponse fetchBookById(BookRequest request);

	@POST
	@Path("/fetchAllBooks/")
	public BookResponse fetchAllBooks(BookRequest request);

	@POST
	@Path("/insertBook/")
	public BookResponse insertBook(BookRequest request);

	@POST
	@Path("/updateBook/")
	public BookResponse updateBook(BookRequest request);

	@POST
	@Path("/deleteBook/")
	public BookResponse deleteBook(BookRequest request);
}
