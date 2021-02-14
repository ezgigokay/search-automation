package org.example;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.restassured.response.Response;

@Test
public class AppTest {

    @Test
    void test_search_api() {
        OMDBSearchApi api = new OMDBSearchApi("24155add");
        Response queryResponse = api.querySearch("Harry Potter");
        String id = queryResponse.jsonPath().getString("Search.find {it.Title == 'Harry Potter and the Sorcerer\\'s Stone'}.imdbID");

        Response idResponse = api.idSearch(id);
        Assert.assertNotNull(idResponse.jsonPath().getString("Title"));
        Assert.assertNotNull(idResponse.jsonPath().getString("Year"));
        Assert.assertNotNull(idResponse.jsonPath().getString("Released"));
        Assert.assertEquals(idResponse.statusCode(),200);
    }

}
