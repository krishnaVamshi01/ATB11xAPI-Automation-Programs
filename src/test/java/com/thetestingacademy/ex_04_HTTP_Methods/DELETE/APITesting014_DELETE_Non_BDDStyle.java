package com.thetestingacademy.ex_04_HTTP_Methods.DELETE;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting014_DELETE_Non_BDDStyle {

    String booking_id = "2064";

    String Token = "fd2591dac332fc6";

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
@Test
    public  void test_DELETE_Booking(){
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + booking_id);
        r.cookie("token" , Token);

        response = r.when().log().all().delete();

        vr = response.then().log().all().statusCode(201);
    }
}
