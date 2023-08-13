package practice;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.Demo;

public class DemoTest {
    Demo demo = new Demo();

    @BeforeClass
    public void login() {
        demo.login("eve.holt@reqres.in", "cityslicka")
                .then()
                .log()
                .body();
    }

    @Test
    public void update() {
        Response login = demo.login("eve.holt@reqres.in", "cityslicka");
        String token = login.getBody().jsonPath().get("token");
        demo.update(token, "1", "mohamed", "tester2");
    }


}
