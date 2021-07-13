package org.example.stepdef.RestSteps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAPITestDef {
    Response response;
    JSONObject request;

    //GET REQUEST
    @Test
    public void GetRequest() {

        response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void VerifyGetRequest() {
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7));
    }

    @Test
    public void VerifyGetRequestBody() {
        given().get("https://reqres.in/api/users?page=2").then().
                statusCode(200).
                body("data.id[1]", equalTo(8)).
                body("data.first_name", hasItems("Michael","Lindsay")).
                log().all();
    }

    @Test
    public void PostRequest() {
        request = new JSONObject();
        request.put("name", "JD");
        request.put("job", "TEST");

        System.out.println(request);

        given().
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().statusCode(201 );
    }

    @Test
    public void PutRequestUpdate() {
        request = new JSONObject();
        request.put("name", "JD");
        request.put("job", "TEST");

        System.out.println(request);

        given().
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users/2").
                then().statusCode(200);
    }

    @Test
    public void PatchRequest() {
        request = new JSONObject();
        request.put("name", "JD");
        request.put("job", "TEST");

        System.out.println(request);

        given().
                body(request.toJSONString()).
                when().
                patch("https://reqres.in/api/users").
                then().statusCode(200);
    }

    @Test
    public void DeleteRequest() {
        request = new JSONObject();
        given().
                body(request.toJSONString()).
                when().
                delete("https://reqres.in/api/users/2").
                then().statusCode(204).
                log().all();
    }
}
