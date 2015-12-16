package com.library.client;

import java.security.InvalidParameterException;

public class SearchBookApiRequest implements IApiRequest {

    private String Name;
    private String Author;

    public SearchBookApiRequest(String name, String author) throws InvalidParameterException {
        if (author == null && name == null) {
            throw new InvalidParameterException("At least one parameter needs to have a value");
        } else {
            Name = name;
            Author = author;
        }
    }

    @Override
    public String toJson() {
        return String.format("{Name: %s,Author: %s,}", Name, Author);
    }
}
