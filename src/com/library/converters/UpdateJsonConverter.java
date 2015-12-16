package com.library.converters;

import java.security.InvalidParameterException;
import org.json.simple.JSONObject;
import com.library.book.model.UpdateBookRequest;

public class UpdateJsonConverter implements IJsonConverter{

	public UpdateBookRequest convert(JSONObject request) throws Exception 
	{
		UpdateBookRequest bookRequest = new UpdateBookRequest();
		
		bookRequest.setOldName((String)request.get("OldName"));
		bookRequest.setOldAuthor((String)request.get("OldAuthor"));
		bookRequest.setNewName((String)request.get("NewName"));
		bookRequest.setNewAuthor((String)request.get("NewAuthor"));
		
		
		if(!enoughParametersSet(bookRequest))
		{
			throw new InvalidParameterException("AddBookRequest: not enough parameters provided!");
		}
		
		return bookRequest;
	}
	
	public Boolean enoughParametersSet(UpdateBookRequest request)
	{
		int numberOfParameters = 0;
		
		if(request.getOldAuthor() != null && request.getOldName() != null)
			numberOfParameters++;
		
		if(request.getNewName() != null || request.getNewAuthor() != null)
			numberOfParameters++;
		
		return numberOfParameters >= 2;
	}
}
