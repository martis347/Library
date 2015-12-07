package com.library.handlers;

import org.json.simple.JSONObject;

import com.library.book.model.BookResponse;

public interface IHandler {

	BookResponse Handle(JSONObject request);
}
