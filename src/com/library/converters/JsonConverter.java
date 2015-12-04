package com.library.converters;

import org.json.simple.JSONObject;
import com.library.book.model.BookRequest;

public class JsonConverter {

	public static BookRequest convert(JSONObject request) throws Exception
	{
		BookRequest bookRequest = new BookRequest();
		
		bookRequest.setName((String)request.get("Name"));
		bookRequest.setAuthor((String)request.get("Author"));
		
		if(bookRequest.getAuthor() == null && bookRequest.getName() == null)
		{
			throw new Exception("You must set Name or Author of the book");
		}
		
		return bookRequest;
	}
}
