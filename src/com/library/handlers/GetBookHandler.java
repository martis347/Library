package com.library.handlers;

import java.security.InvalidParameterException;
import java.sql.SQLDataException;
import org.json.simple.JSONObject;
import com.library.book.model.Book;
import com.library.book.model.BookRequest;
import com.library.book.model.BookResponse;
import com.library.converters.JsonConverter;
import com.library.sql.dao.impl.SQLManager;

public class GetBookHandler implements IHandler {

	private SQLManager sqlManager;
	
	public GetBookHandler(SQLManager sqlManager)
	{
		this.sqlManager = sqlManager;
	}
	
	public BookResponse Handle(JSONObject request) {
		
		BookResponse response = new BookResponse();
		
		try {
			BookRequest bookRequest = JsonConverter.convert(request);
			
			response.setBook(getBook(bookRequest));

		} catch (InvalidParameterException e) {
			response.onError("You must set Name or Author of the book");
		} catch (SQLDataException e) {
			response.onError("No book found for given request");
		} catch (Exception e) {
			response.onError("Unexpected error has occured", e);
		}
		
		return response;
	}
	
	private Book getBook(BookRequest request) throws Exception
	{
		Book book = null;
		
		if(request.getName() != null)
		{
			book = sqlManager.getBookByName(request.getName());
		}
		if(book == null && request.getAuthor() != null )
		{
			//book = sqlManager.getBookByAuthor(request.getName());
		}
		if (book == null)
		{
			throw new SQLDataException("No book found for given request");
		}
		
		return book;
	}

}
