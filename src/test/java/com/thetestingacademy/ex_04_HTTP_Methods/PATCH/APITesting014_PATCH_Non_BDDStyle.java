package com.thetestingacademy.ex_04_HTTP_Methods.PATCH;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting014_PATCH_Non_BDDStyle {
//     https://restful-booker.herokuapp.com/booking/1 \
//  -H 'Content-Type: application/json' \
//  -H 'Accept: application/json' \
//  -H 'Cookie: token=abc123' \
//  -d '{
//    "firstname" : "James",
//    "lastname" : "Brown"
//}'

    String token = "0a0590fb42a12d6";
    String Booking_id = "742";

    String payload_PATCH = "{\n" +
            "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Brown\"\n" +
            "}";

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public  void test_PATCH_Booking(){
        r = RestAssured.given();
                r.baseUri("https://restful-booker.herokuapp.com");
                r.basePath("/booking/" + Booking_id);
                r.cookie("8f69fdd82760c3a");
                r.body(payload_PATCH);
                r.cookie("token" , token);

                response = r.when().log().all().patch();


                vr = response.then().log().all().statusCode(200);
    }
}


