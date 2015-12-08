package com.library.converters;

import java.security.InvalidParameterException;
import org.json.simple.JSONObject;
import com.library.book.model.GetBookRequest;

public class GetBookJsonConverter implements IJsonConverter{

	public GetBookRequest convert(JSONObject request) throws Exception
	{
		GetBookRequest bookRequest = new GetBookRequest();
		
		bookRequest.setName((String)request.get("Name"));
		bookRequest.setAuthor((String)request.get("Author"));
		
		if(bookRequest.getAuthor() == null && bookRequest.getName() == null)
		{
			throw new InvalidParameterException("You must set Name or Author of the book");
		}
		
		return bookRequest;
	}
	
	
}
