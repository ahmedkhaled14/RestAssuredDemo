package practice;

import POJO.AuthorObj;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.Authors;

public class AuthorsTest {
    Authors author = new Authors();

    @Test(description = "get last author")
    public void getLastAuthor(){
        Response response = author.getAllAuthors();
        response.then().log().body();

        AuthorObj[] data = response.body().as(AuthorObj[].class);
        String length = String.valueOf(data.length);
        System.out.println(" last author id = " +length);

        author.getLastAuthor(length)
                .then()
                .log()
                .body();
    }
}
