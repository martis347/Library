package com.library.client;

import com.library.book.model.Book;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.AbstractMap;
import java.util.Set;

public class LibraryApiClient extends AbstractMap<IApiRequest, JSONObject> {

    private final String API_URL;

    public LibraryApiClient(String url) throws MalformedURLException {
        API_URL = url;
    }

    @Override
    public JSONObject get(IApiRequest request) throws IOException {
        GetBookApiRequest getRequest = (GetBookApiRequest) request;

        JSONObject bookJson = executPostRequest("/getBook", getRequest);

        return  bookJson;
    }

    @Override
    public JSONObject put(IApiRequest request, String s) throws Exception {
        PutBookApiRequest putRequest = (PutBookApiRequest) request;

        JSONObject putResponse = executPostRequest("/addBook", putRequest);

        return putResponse;
    }

    public JSONObject search(IApiRequest request) throws IOException {
        SearchBookApiRequest searchRequest = (SearchBookApiRequest) request;

        JSONObject searchResponse = executPostRequest("/search", searchRequest);

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

        int responseCode = httpsConnection.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(httpsConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject searchResponse = new JSONObject(response.toString());

        return searchResponse;
    }

    @Override
    public Set<Entry<IApiRequest, Book>> entrySet() {
        throw new NotImplementedException();
    }
}
