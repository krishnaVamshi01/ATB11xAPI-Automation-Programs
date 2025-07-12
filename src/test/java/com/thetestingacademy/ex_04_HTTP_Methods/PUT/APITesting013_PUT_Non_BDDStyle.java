package com.thetestingacademy.ex_04_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting013_PUT_Non_BDDStyle {
//     https://restful-booker.herokuapp.com/booking/1 \
//  -H 'Content-Type: application/json' \
//  -H 'Accept: application/json' \
//  -H 'Cookie: token=abc123' \
//  -d '{
//    "firstname" : "James",
//    "lastname" : "Brown",
//    "totalprice" : 111,
//    "depositpaid" : true,
//    "bookingdates" : {
//        "checkin" : "2018-01-01",
//        "checkout" : "2019-01-01"
//    },
//    "additionalneeds" : "Breakfast"
//}'

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    String Booking_id = "3979";
    String Token = "a59f39c6024b2fb";

    String Payload_PUT = "{\n" +
            "    \"firstname\" : \"Baahubali\",\n" +
            "    \"lastname\" : \"Prabhas\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    @Test
    public void test_PATCH_Booking(){

        r = RestAssured.given();
                r.baseUri("https://restful-booker.herokuapp.com");
                r.basePath("/booking/" + Booking_id);
                r.contentType(ContentType.JSON);
                r.body(Payload_PUT);
                r.cookie("token" , Token);

                response = r.when().log().all().put();


                vr = response.then().log().all().statusCode(200);


    }



}