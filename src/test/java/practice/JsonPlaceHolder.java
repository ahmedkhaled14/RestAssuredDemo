package practice;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class JsonPlaceHolder {

    RequestSpecification requestSpecification = given().baseUri("https://jsonplaceholder.typicode.com").basePath("posts");
    ResponseSpecification responseSpecification = expect().contentType(ContentType.JSON);

    @Test
    public void getResource() {
        requestSpecification
                .get("/1")
                .then()
                .spec(responseSpecification)
                .log()
                .body();

    }

    @Test
    public void listingAllResources() {
        requestSpecification
                .get()
                .then()
                .spec(responseSpecification)
                .log()
                .body();

    }

    @Test
    public void createResources() {
        requestSpecification
                .body("""
                        {
                         "title": "foo",
                          "body": "bar",
                        "userId": 1,
                        }
                        """)
                .post()
                .then()
                .spec(responseSpecification)
                .log()
                .body();

    }

    @Test
    public void updateResources() {
        requestSpecification
                .body("""
                        {
                        "id": 1,
                        "title": "foo",
                        "body": "bar",
                        "userId": 1,
                        }
                        """)
                .when()
                .put("/1")
                .then()
                .spec(responseSpecification)
                .log()
                .body();

    }


    @Test
    public void patchResources() {
        requestSpecification
                .body("""
                        {
                            "title": "foo",
                        }
                        """)
                .when()
                .patch("/1")
                .then()
                .spec(responseSpecification)
                .log()
                .body();

    }

    @Test
    public void deleteResource() {
        requestSpecification
                .delete("/1")
                .then()
                .spec(responseSpecification)
                .log()
                .body();

    }


}
