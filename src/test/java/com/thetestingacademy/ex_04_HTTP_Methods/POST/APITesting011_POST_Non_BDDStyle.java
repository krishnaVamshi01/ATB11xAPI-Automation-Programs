package com.thetestingacademy.ex_04_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_POST_Non_BDDStyle {
// https://restful-booker.herokuapp.com/auth \
//  -H 'Content-Type: application/json' \
//  -d '{
//    "username" : "admin",
//    "password" : "password123"
//}'
RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    String payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";


    @Test
    public void test_POST_Auth(){

        r = RestAssured.given()
                .when()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .log().all().body(payload);

        response = r.when().log().all().post();

        vr = response.then().log().all().statusCode(200);

    }



}