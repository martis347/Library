package com.library.handlers;

import java.security.InvalidParameterException;
import java.sql.SQLDataException;
import org.json.simple.JSONObject;
import com.library.book.model.AddBookRequest;
import com.library.book.model.AddBookResponse;
import com.library.book.model.Book;
import com.library.converters.IJsonConverter;
import com.library.sql.dao.impl.SQLManager;

public class AddBookHandler implements IHandler{

private SQLManager sqlManager;
private IJsonConverter converter;
	
	public AddBookHandler(SQLManager sqlManager, IJsonConverter converter)
	{
		this.sqlManager = sqlManager;
		this.converter = converter;
	}

	public AddBookResponse Handle(JSONObject request) {
		
		AddBookResponse response = new AddBookResponse();
		
		try {
			AddBookRequest bookRequest = (AddBookRequest) converter.convert(request);
			
			response.setMessage(addBook(bookRequest));

		} catch (InvalidParameterException e) {
			response.onError("You must provide at least two parameters");
		} catch (SQLDataException e) {
			response.onError("No book found for given request");
		} catch (Exception e) {
			response.onError("Unexpected error has occured", e);
		}
		
		return response;
	}
	
	private String addBook(AddBookRequest request) throws Exception
	{
		//sqlManager.getBookByName(request.getName());
		
		return "Test implementation";
	}
	
	

}
