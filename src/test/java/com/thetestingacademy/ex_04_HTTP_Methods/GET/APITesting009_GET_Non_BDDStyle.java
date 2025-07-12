package com.thetestingacademy.ex_04_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_GET_Non_BDDStyle {

    String pincode = "505001";

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Test
    public void test_GET_Positive() {
//       https://api.zippopotam.us/IN/505001

        r = RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode);

        response = r.when().log().all().get();
        System.out.println(response.asString());

        vr = response.then().log().all();
        vr.statusCode(200);


    }

    @Test
    public void test_GET_Negative() {
//       https://api.zippopotam.us/IN/505001

        String pincode = "50500";

        r = RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode);

        response = r.when().log().all().get();
        System.out.println(response.asString());

        vr = response.then().log().all();
        vr.statusCode(200);


    }
}