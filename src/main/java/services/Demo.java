package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Demo {
   private RequestSpecification requestSpecification;

    public Demo() {
        requestSpecification = given().contentType(ContentType.JSON)
                .baseUri("https://reqres.in").basePath("api");
    }

    public Response login(String userName , String password){
        return given().spec(requestSpecification)
                .body(loginBody(userName,password))
                .post("/login");
    }

    public Response update(String token,String id ,String name , String job){
        return given().spec(requestSpecification)
                .header("Authorization","Bearer " + token)
                .pathParam("id",id)
                .body(updateBody(name , job))
                .put("/users");
    }


    private String loginBody(String userName , String password ) {
        return
                """
                        {
                               "userName": $userName,
                               "password": $password,
                        }
                """
                        .replace("$userName",userName)
                        .replace("$password",password);

    }

    private String updateBody(String name , String job){
        return """
                        {
                               "name": $name,
                               "job": $job,
                        }
                """
                .replace("$name",name)
                .replace("$job",job);
    }

}
