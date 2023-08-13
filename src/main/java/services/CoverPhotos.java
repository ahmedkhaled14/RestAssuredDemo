package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CoverPhotos {
    private RequestSpecification requestSpecification;
    public CoverPhotos(){
        requestSpecification = given().contentType(ContentType.JSON)
                .baseUri("https://fakerestapi.azurewebsites.net")
                .basePath("api/v1/CoverPhotos");
    }
    public Response getAllCoverPhotos() {
        return given().spec(requestSpecification)
                .get();
    }

    public Response createCoverPhoto(String id , String idBook , String url) {
        return given().spec(requestSpecification)
                .body(CoverPhotoBody(id,idBook,url))
                .post();
    }

    public Response getCoverPhotoByBookId(String id) {
        return given().spec(requestSpecification)
                .pathParam("id",id)
                .get("books/covers/{id}");
    }

    public Response getCoverPhotoById(String id) {
        return given().spec(requestSpecification)
                .pathParam("id",id)
                .get("/{id}");

    }

    public Response updateCoverPhotoById(String pathParamId, String id , String idBook , String url) {
        return given().spec(requestSpecification)
                .pathParam("id", pathParamId)
                .body(CoverPhotoBody(id,idBook,url))
                .put("/{id}");

    }

    public Response deleteCoverPhotoById(String id) {
        return given().spec(requestSpecification)
                .pathParam("id",id)
                .delete("/{id}");
    }

    private String CoverPhotoBody(String id , String idBook , String url) {
        return
                """
                        {
                               "id": $id,
                               "idBook": $idBook,
                               "url": "$url"
                        }
                """
                        .replace("$id",id)
                        .replace("$idBook",idBook)
                        .replace("$url",url);
    }
}

