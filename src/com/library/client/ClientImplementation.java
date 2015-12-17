package com.library.client;

import java.util.HashMap;

import org.apache.log4j.Logger;

public class ClientImplementation {

	private static final Logger logger = Logger.getLogger(ClientImplementation.class.getName());

	LibraryApiClient  client = new LibraryApiClient("http://localhost:8080/Library/services");
	
	AddBookApiRequest addBookRequest1 = new AddBookApiRequest("Pride and Prejudice", "Jane Austen", null);
	AddBookApiRequest addBookRequest2 = new AddBookApiRequest("The Lord of the Rings", "JRR Tolkien", null);
	AddBookApiRequest addBookRequest3 = new AddBookApiRequest("Jane Eyre", "Charlotte Bronte", "Martynas Kanapinskas");
	AddBookApiRequest addBookRequest4 = new AddBookApiRequest("To Kill a Mockingbird", "Harper Lee", null);
	
	
	GetBookApiRequest getBookRequest1 = new GetBookApiRequest("Jane Eyre", "Charlotte Bronte");
	GetBookApiRequest getBookRequest2 = new GetBookApiRequest("Pride and Prejudice", "Jane Austen");
	GetBookApiRequest getBookRequest3 = new GetBookApiRequest("test name", "false author");
	
	
	PutBookApiRequest putBookRequest1 = new PutBookApiRequest("The Lord of the Rings", "JRR Tolkien", "Ziedu valdovas", null);
	PutBookApiRequest putBookRequest2 = new PutBookApiRequest("To Kill a Mockingbird", "JRR Tolkien", "Nuzudyti Strazda Giesmininka", null);
	PutBookApiRequest putBookRequest3 = new PutBookApiRequest("Jane Eyre", "Charlotte Bronte", null, "Sarlote Bronte");
	
	
	SearchBookApiRequest searchBookRequest1 = new SearchBookApiRequest(null, "Sarlote Bronte");
	SearchBookApiRequest searchBookRequest2 = new SearchBookApiRequest(null, "Harper Lee");
	

    HashMap<Integer, String> hmap = new HashMap<Integer, String>();

    public void main(String[] args)
    {
    	try {
			client.add(addBookRequest1);
			client.add(addBookRequest2);
			client.add(addBookRequest3);
			client.add(addBookRequest4);
		} catch (Exception e) {
			logger.error("Server error", e);
		}
    }
	
	
	

}
