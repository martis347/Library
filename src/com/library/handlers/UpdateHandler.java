package com.library.handlers;

import java.security.InvalidParameterException;
import java.sql.SQLDataException;
import org.json.simple.JSONObject;
import com.library.book.model.UpdateBookRequest;
import com.library.book.model.UpdateBookResponse;
import com.library.converters.IJsonConverter;
import com.library.sql.dao.impl.SQLManager;

public class UpdateHandler implements IHandler{

	private SQLManager sqlManager;
	private IJsonConverter converter;
		
		public UpdateHandler(SQLManager sqlManager, IJsonConverter converter)
		{
			this.sqlManager = sqlManager;
			this.converter = converter;
		}

		public UpdateBookResponse Handle(JSONObject request) {
			
			UpdateBookResponse response = new UpdateBookResponse();
			
			try {
				UpdateBookRequest bookRequest = (UpdateBookRequest) converter.convert(request);
				
				response.setBook(sqlManager.updateBook(bookRequest));

			} catch (InvalidParameterException e) {
				response.onError("You must provide current Name and Author and new Name or Author");
			} catch (SQLDataException e) {
				response.onError("Failed to Update a book");
			} catch (Exception e) {
				response.onError("Unexpected error has occured", e);
			}
			
			return response;
		}
}
