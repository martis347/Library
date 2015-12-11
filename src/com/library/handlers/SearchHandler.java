package com.library.handlers;

import java.security.InvalidParameterException;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.EmptyStackException;

import org.json.simple.JSONObject;
import com.library.book.model.SearchRequest;
import com.library.book.model.SearchResponse;
import com.library.converters.IJsonConverter;
import com.library.metaphone.Metaphone;
import com.library.sql.dao.impl.SQLManager;

public class SearchHandler implements IHandler{
	
	private SQLManager sqlManager;
	private IJsonConverter converter;
	private Metaphone metaphone;
	private String searchObject;
	
	public SearchHandler(SQLManager sqlManager, IJsonConverter converter, Metaphone metaphone)
	{
		this.sqlManager = sqlManager;
		this.converter = converter;
		this.metaphone = metaphone;
	}
	
	public SearchResponse Handle(JSONObject request) {
		
		SearchResponse response = new SearchResponse();
		ArrayList<String> allWords = new ArrayList<String>();
		ArrayList<String> matchingWords = new ArrayList<String>();
		
		
		try {
			SearchRequest searchRequest = (SearchRequest) converter.convert(request);
			
			allWords = getAllWords(searchRequest);
			
			matchingWords = metaphone.doTheMagic(allWords, searchRequest.getName());
			
			response.setValue(matchingWords, searchObject);
			
			if(response.isResponseEmpty())
			{
				throw new EmptyStackException();
			}

		} catch (InvalidParameterException e) {
			response.onError("You must set Name or Author of the book");
		} catch (SQLDataException e) {
			response.onError("Sorry, database is empty");
		} catch (EmptyStackException e) {
			response.onError("Sorry, search has yielded no results");
		} catch (Exception e) {
			response.onError("Unexpected error has occured", e);
		}
		
		return response;
	}
	
	private ArrayList<String> getAllWords(SearchRequest searchRequest) throws Exception
	{
		ArrayList<String> list = new ArrayList<String>();
		
		if(searchRequest.getName() != null)
		{
			list = sqlManager.searchByName();
			searchObject = "name";
		}
		if(list == new ArrayList<String>() && searchRequest.getAuthor() != null )
		{
			//list = sqlManager.searchByAuthor(searchRequest.getAuthor());
			searchObject = "author";
		}
		if (list == new ArrayList<String>())
		{
			throw new SQLDataException("Sorry, database is empty");
		}

		return list;
	}
}
