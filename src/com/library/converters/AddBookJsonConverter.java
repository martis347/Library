package com.library.converters;

import java.security.InvalidParameterException;
import java.util.Date;
import org.json.simple.JSONObject;
import com.library.book.model.AddBookRequest;

public class AddBookJsonConverter implements IJsonConverter{

	public AddBookRequest convert(JSONObject request) throws Exception 
	{
		AddBookRequest bookRequest = new AddBookRequest();

		java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
		
		bookRequest.setName((String)request.get("Name"));
		bookRequest.setAuthor((String)request.get("Author"));
		bookRequest.setTakenBy((String)request.get("TakenBy"));
		bookRequest.setEntryDate(sqlDate);
		
		
		if(!enoughParametersSet(bookRequest))
		{
			throw new InvalidParameterException("AddBookRequest: not enough parameters provided!");
		}
		
		return bookRequest;
	}
	
	public Boolean enoughParametersSet(AddBookRequest request)
	{
		int numberOfParameters = 0;
		
		if(request.getName() != null)
			numberOfParameters++;
		
		if(request.getAuthor() != null)
			numberOfParameters++;
		
		if(request.getTakenBy() != null)
			numberOfParameters++;
		
		return numberOfParameters >= 2;
	}
}
