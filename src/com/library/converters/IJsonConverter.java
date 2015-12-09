package com.library.converters;

import org.json.simple.JSONObject;
import com.library.book.model.IRequest;

public interface IJsonConverter {
	
	public IRequest convert(JSONObject request) throws Exception;
}
