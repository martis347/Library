package com.library.client;

import java.security.InvalidParameterException;
import java.sql.Date;

public class PutBookApiRequest implements IApiRequest {
    private String Name;
    private String Author;
    private String TakenBy;

    public PutBookApiRequest(String name, String author, String takenBy)
    {
        if(name == null || author == null)
        {
            throw new InvalidParameterException();
        }
        else
        {
            Name = name;
            Author = author;
            TakenBy = takenBy;
        }
    }

    @Override
    public String toJson() {
        return String.format("{Author: %s, Name: %s}", Author, Name);
    }
}
