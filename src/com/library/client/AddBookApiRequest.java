package com.library.client;

import java.security.InvalidParameterException;

public class AddBookApiRequest implements IApiRequest{

    private String Name;
    private String Author;
    private String TakenBy;

    public AddBookApiRequest(String name, String author, String takenBy)
    {
        if(name == null || author == null)
        {
            throw new InvalidParameterException("Name and Author book must be set");
        }
        
        Name = name;
        Author = author;
        TakenBy = takenBy;     
        }
    

    @Override
    public String toJson() {
        return String.format("{Author: %s, Name: %s}", Author, Name);
    }
}
