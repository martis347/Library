package com.library.converters;

import java.security.InvalidParameterException;
import org.json.simple.JSONObject;
import com.library.book.model.SearchRequest;

public class SearchJsonConverter implements IJsonConverter{
	public SearchRequest convert(JSONObject request) throws Exception
	{
		SearchRequest searchRequest = new SearchRequest();
		
		searchRequest.setName((String)request.get("Name"));
		searchRequest.setAuthor((String)request.get("Author"));
		
		if(searchRequest.getAuthor() == null && searchRequest.getName() == null)
		{
			throw new InvalidParameterException("You must set Name or Author of the book");
		}
		
		return searchRequest;
	}
}
