package practice;

import POJO.AuthorObj;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.Authors;

public class AuthorsTest {
    Authors author = new Authors();

    @Test(description = "get last author")
    public void getLastAuthor(){

        /**
         *                    (Not Required)
         * get all authors just for comparing with the last Author
         *                   
         */
        Response getAllAuthors = author.getAllAuthors();
        getAllAuthors.then().log().body();

        /**
         *  get last author
         */
        AuthorObj[] data = getAllAuthors.body().as(AuthorObj[].class);
        String lastAuthorId = String.valueOf(data[data.length-1].getId());
        Response lastAuthor = author.getLastAuthor(lastAuthorId);
        lastAuthor.then().log().body();


        /**
         *                      Validation on ID
         *
         * get the last author id from lastAuthor response body and validate that
         * the Author id
         * Is equal to
         * the Expected the Last Author id
         */
        JsonPath jsonpath= lastAuthor.jsonPath();
        String getActualLastAuthorID = String.valueOf(jsonpath.getInt("id"));
        Assert.assertEquals(getActualLastAuthorID,lastAuthorId);
    }
}
