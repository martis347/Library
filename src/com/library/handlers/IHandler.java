package com.library.handlers;

import org.json.simple.JSONObject;

import com.library.book.model.GetBookResponse;
import com.library.book.model.IResponse;

public interface IHandler {

	IResponse Handle(JSONObject request);
}
