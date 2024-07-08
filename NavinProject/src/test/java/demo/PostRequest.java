package demo;

import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostRequest {
    @Test
    public void create()
    {
        JSONObject jsonData = new JSONObject();

        jsonData.put("id","8");
        jsonData.put("name","Praveen");
        jsonData.put("age","22");
        jsonData.put("grade","B");

        RestAssured.baseURI="http://localhost:3000/students";

        RestAssured.given()
                .header("content-type","application/json")
                .body(jsonData.toJSONString())
                .when()
                .post()
                .then()
                .statusCode(201)
                .log().all();

    }
}
