package com.library.client;

import java.security.InvalidParameterException;

public class PutBookApiRequest implements IApiRequest {
    private String OldName;
    private String OldAuthor;
    private String NewName;
    private String NewAuthor;

    public PutBookApiRequest(String oldName, String oldAuthor, String newName, String newAuthor)
    {
        if(oldName == null || oldAuthor == null)
        {
            throw new InvalidParameterException("Name and Author of old book must be set");
        }
        
        OldName = oldName;
        OldAuthor = oldAuthor;
        NewName = newName;
        NewAuthor = newAuthor;
    }

    @Override
    public String toJson() {
        return String.format("{OldAuthor: %s, OldName: %s}", OldAuthor, OldName);
    }
}
