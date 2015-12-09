package com.library.handlers;

import java.security.InvalidParameterException;
import java.sql.SQLDataException;
import org.json.simple.JSONObject;
import com.library.book.model.Book;
import com.library.book.model.GetBookRequest;
import com.library.book.model.GetBookResponse;
import com.library.converters.IJsonConverter;
import com.library.sql.dao.impl.SQLManager;

public class GetBookHandler implements IHandler {

	private SQLManager sqlManager;
	private IJsonConverter converter;
	
	public GetBookHandler(SQLManager sqlManager, IJsonConverter converter)
	{
		this.sqlManager = sqlManager;
		this.converter = converter;
	}
	
	public GetBookResponse Handle(JSONObject request) {
		
		GetBookResponse response = new GetBookResponse();
		
		try {
			GetBookRequest bookRequest = (GetBookRequest) converter.convert(request);
			
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
	
	private Book getBook(GetBookRequest request) throws Exception
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
