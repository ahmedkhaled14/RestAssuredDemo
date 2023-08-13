package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Authors {

    private RequestSpecification requestSpecification;
    public Authors(){
        requestSpecification = given().contentType(ContentType.JSON)
                .baseUri("https://fakerestapi.azurewebsites.net")
                .basePath("api/v1/Authors");
    }
    public Response getAllAuthors() {
        return given().spec(requestSpecification)
                .get();
    }

    public Response getLastAuthor(String id){
        return given()
                .spec(requestSpecification)
                .get("/"+id);
    }
}
