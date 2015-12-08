package com.library.converters;

import org.json.simple.JSONObject;
import com.library.book.model.IBookRequest;

public interface IJsonConverter {
	
	public IBookRequest convert(JSONObject request) throws Exception;
}
