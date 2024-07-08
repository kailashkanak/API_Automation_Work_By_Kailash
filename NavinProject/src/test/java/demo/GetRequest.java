package demo;


import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetRequest {
    @Test
    public void getData()
    {
       // RestAssured.get("http://localhost:3000/students");
        RestAssured.baseURI="http://localhost:3000/students";

        RestAssured.given()
                .header("content-type","application/json")
                .when()
                .get()
                .then()
                .statusCode(200)
                .log().all();
    }
}
