package com.thetestingacademy.ex_04_HTTP_Methods.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting008_GET_BDDStyle {

    String pincode;


    @Test
    public void test_GET_Positive(){
//       https://api.zippopotam.us/IN/505001
        pincode = "505001";

        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/"+ pincode)
                .when()
                    .log()
                    .all()
                .get()
                .then()
                    .log()
                    .all()
                    .statusCode(200);




    }



}
