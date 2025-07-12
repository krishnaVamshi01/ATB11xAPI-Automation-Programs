package com.thetestingacademy.ex_04_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.codehaus.groovy.syntax.Token;
import org.testng.annotations.Test;

public class APITesting012_PUT_BDDStyle {

// "bookingid": 3795,
// "token": "bb0d532260ec769"

//    https://restful-booker.herokuapp.com/booking/1 \
//            -H 'Content-Type: application/json' \
//            -H 'Accept: application/json' \
//            -H 'Cookie: token=abc123' \
//
//}'

    String Booking_id = "2868" ;
    String Token = "ff5005157fd91da";

    String PayLoad_PUT = "{\n" +
            "    \"firstname\" : \"RAO\",\n" +
            "    \"lastname\" : \"KRISHNA VAMSHI\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    @Test
    public void test_PUT_Update_Booking(){
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/" +Booking_id)
                .contentType(ContentType.JSON)
                .cookie("token", Token)
                .body(PayLoad_PUT)
                .when()
                .log().all().put()
                .then()
                .log()
                .all().statusCode(200);

    }




}