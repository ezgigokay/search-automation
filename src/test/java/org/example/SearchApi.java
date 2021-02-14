package org.example;

import io.restassured.response.Response;

public interface SearchApi {
    Response querySearch (String queryString);
    Response idSearch (String id);
}
