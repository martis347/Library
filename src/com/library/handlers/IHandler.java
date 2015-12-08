package com.library.handlers;

import org.json.simple.JSONObject;

import com.library.book.model.GetBookResponse;
import com.library.book.model.IBookResponse;

public interface IHandler {

	IBookResponse Handle(JSONObject request);
}
