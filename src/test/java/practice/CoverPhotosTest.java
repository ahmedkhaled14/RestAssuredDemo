package practice;

import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import services.CoverPhotos;

import static io.restassured.RestAssured.expect;



public class CoverPhotosTest {
    CoverPhotos coverPhotos = new CoverPhotos();
    ResponseSpecification responseSpecification = expect()
            .statusCode(200)
            .contentType(ContentType.JSON);

    @Test
    public void getAllCoverPhotos() {
        coverPhotos.getAllCoverPhotos()
                .then()
                .spec(responseSpecification)
                .log()
                .body();
    }

    @Test
    public void createCoverPhoto() {
        coverPhotos.createCoverPhoto("0","0","www.url.com")
                .then()
                .spec(responseSpecification)
                .log()
                .body();

    }

    @Test
    public void getCoverPhotoByBookId() {
        coverPhotos
                .getCoverPhotoByBookId("1")
                .then()
                .spec(responseSpecification)
                .log()
                .body();

    }

    @Test
    public void getCoverPhotoById() {
        coverPhotos.getCoverPhotoById("1")
                .then()
                .spec(responseSpecification)
                .log()
                .body();

    }

    @Test
    public void updateCoverPhotoById() {
       coverPhotos.updateCoverPhotoById("1","1","1","www.updateUrl.com")
                .then()
                .spec(responseSpecification)
                .log()
                .body();

    }

    @Test
    public void deleteCoverPhotoById() {
       coverPhotos
               .deleteCoverPhotoById("1")
                .then()
                .log()
                .body();
    }
}

