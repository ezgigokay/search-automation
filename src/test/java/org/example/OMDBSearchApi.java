package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OMDBSearchApi implements SearchApi {
    private String apikey;
    private static String url = "http://www.omdbapi.com/";

    public OMDBSearchApi(String apikey) {
        this.apikey = apikey;
    }

    @Override
    public Response querySearch (String queryString){
        return RestAssured.get(url + "?s="+queryString + "&" + "apikey=" + apikey);
    }

    @Override
    public Response idSearch (String id) {
        return RestAssured.get(url + "?i=" + id + "&" + "apikey=" + apikey);
    }
}
