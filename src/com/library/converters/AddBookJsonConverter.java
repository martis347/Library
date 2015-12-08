package com.library.converters;

import java.security.InvalidParameterException;
import java.sql.Date;

import org.json.simple.JSONObject;
import com.library.book.model.AddBookRequest;

public class AddBookJsonConverter implements IJsonConverter{

	public AddBookRequest convert(JSONObject request) throws Exception 
	{
		AddBookRequest bookRequest = new AddBookRequest();
		
		bookRequest.setName((String)request.get("Name"));
		bookRequest.setAuthor((String)request.get("Author"));
		bookRequest.setEntryDate((Date)request.get("EntryDate"));
		bookRequest.setTakenBy((String)request.get("TakenBy"));
		
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
		
		if(request.getEntryDate() != null)
			numberOfParameters++;
		
		if(request.getTakenBy() != null)
			numberOfParameters++;
		
		return numberOfParameters >= 2;
	}
}
