package com.library.client;


import java.security.InvalidParameterException;

public class GetBookApiRequest implements IApiRequest {

    private String Name;
    private String Author;

    public GetBookApiRequest(String name, String author) throws InvalidParameterException
    {
        if(author == null && name == null)
        {
            throw new InvalidParameterException("At least one parameter needs to have a value");
        }
        else
        {
            Name = name;
            Author = author;
        }
    }

    @Override
    public String toJson() {
        return String.format("{Name: %s,Author: %s,}", Name, Author);
    }
}
