package practice;

import POJO.AuthorObj;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.Authors;

public class AuthorsTest {
    Authors author = new Authors();

    @Test(description = "get last author")
    public void getLastAuthor(){
        Response response = author.getAllAuthors();
        response.then().log().body();

        AuthorObj[] data = response.body().as(AuthorObj[].class);

        String lastAuthorId = String.valueOf(data[data.length-1].getId());

        System.out.println(" get last author id = " +lastAuthorId);

        author.getLastAuthor(lastAuthorId)
                .then()
                .log()
                .body();
    }
}
