package com.library.client;

import com.library.book.model.AddBookResponse;
import com.library.book.model.Book;
import com.library.book.model.UpdateBookResponse;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.AbstractMap;
import java.util.Set;

public class LibraryApiClient extends AbstractMap<IApiRequest, JSONObject> {

	private static final Logger logger = Logger.getLogger(LibraryApiClient.class.getName());
    private final String API_URL;

    public LibraryApiClient(String url)  {
        API_URL = url;
    }

    public JSONObject get(IApiRequest request) throws IOException {
        GetBookApiRequest getRequest = (GetBookApiRequest) request;

        JSONObject bookJson = executPostRequest("/getBook", getRequest);
        System.out.println(bookJson);
        return  bookJson;
    }

    public JSONObject add(IApiRequest request, String s) throws Exception {
        PutBookApiRequest putRequest = (PutBookApiRequest) request;

        JSONObject addResponse = executPostRequest("/addBook", putRequest);
        System.out.println(addResponse);
        return addResponse;
    }
    
    public JSONObject put(IApiRequest request, String s) throws Exception {
        PutBookApiRequest putRequest = (PutBookApiRequest) request;

        JSONObject putResponse = executPostRequest("/updateBook", putRequest);
        System.out.println(putResponse);
        return putResponse;
    }

    public JSONObject search(IApiRequest request) throws IOException {
        SearchBookApiRequest searchRequest = (SearchBookApiRequest) request;

        JSONObject searchResponse = executPostRequest("/search", searchRequest);
        System.out.println(searchResponse);
        return searchResponse;
    }

    private JSONObject executPostRequest(String requestUrl, IApiRequest request) throws IOException {

        URL apiRequestURL = new URL(API_URL + requestUrl);
        HttpsURLConnection httpsConnection =  (HttpsURLConnection) apiRequestURL.openConnection();
        httpsConnection.setRequestMethod("POST");
        httpsConnection.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(httpsConnection.getOutputStream());
        wr.writeBytes(request.toJson());
        wr.flush();
        wr.close();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(httpsConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONParser parser = new JSONParser();
        JSONObject requestResponse = null;
		try {
			requestResponse = (JSONObject) parser.parse(response.toString());
		} catch (ParseException e) {
			logger.error("Unable to parse response");
		}
        
        return requestResponse;
    }

	public Set<java.util.Map.Entry<IApiRequest, JSONObject>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
