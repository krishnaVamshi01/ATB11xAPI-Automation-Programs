package com.thetestingacademy.ex_06_TestAssetions;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;


public class Allure_Report_with_Assertions {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    Integer bookingid;

    String POST_PayLoad = "{\n" +
            "    \"firstname\" : \"Krishna\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    @Owner("Krishna Vamshi")
    @Description("Veryfying the test cases")
    @Severity(SeverityLevel.CRITICAL)

    @Test(priority = 1)
    public void Test_Create_Booking() {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(POST_PayLoad).log().all();

        response = requestSpecification.when().post();

        validatableResponse = response.then().log().all().statusCode(200);

        bookingid = response.then().extract().path("bookingid"); // ✅ Correct extraction

        // Assertions
        validatableResponse.body("booking.firstname", Matchers.equalTo("Krishna"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Brown"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
        validatableResponse.body("bookingid", Matchers.notNullValue());
    }

    @Test(dependsOnMethods = {"Test_Create_Booking"}, priority = 2)
    public void Test_Get_Booking() {

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingid);  // ✅ Correct use of bookingid
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.log().all();

        response = requestSpecification.when().get();

        validatableResponse = response.then().log().all().statusCode(200);

        // Extract booking details
        String firstname = response.then().extract().path("firstname");
        String lastname = response.then().extract().path("lastname");

        // Assertions
        Assert.assertEquals(firstname, "Krishna");
        Assert.assertEquals(lastname, "Brown");
        Assert.assertNotNull(bookingid); // Optional
    }

    //    AssertJ
    @Test(dependsOnMethods = {"Test_Create_Booking"}, priority = 3)

    public void Test_UPDATE_Booking() {

        // 🔁 Updated payload (note: changed "lastname" to "Vamshi")
        String PUT_Payload = "{\n" +
                "    \"firstname\" : \"Krishna\",\n" +
                "    \"lastname\" : \"Vamshi\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(PUT_Payload).log().all();
        requestSpecification.auth().preemptive().basic("admin", "password123");


        response = requestSpecification.when().put();

        validatableResponse = response.then().log().all().statusCode(200);


        // ✅ AssertJ assertion on response content
        String updatedLastname = response.then().extract().path("lastname");
        assertThat(updatedLastname).isEqualTo("Vamshi");


    }

    @Test(dependsOnMethods = {"Test_Create_Booking"}, priority = 4)

    public void Test_PARTIAL_UPDATE_Booking() {
        // 🔁 Updated payload (note: changed "lastname" to "Vamshi")
        String PATCH_Payload = "{\n" +
                "    \"firstname\" : \"Krishna\",\n" +
                "    \"lastname\" : \"Vamshi RAO\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(PATCH_Payload).log().all();
        requestSpecification.auth().preemptive().basic("admin", "password123");


        response = requestSpecification.when().patch();

        validatableResponse = response.then().log().all().statusCode(200);


        // ✅ AssertJ assertion on response content
        String updatedLastname = response.then().extract().path("lastname");
        assertThat(updatedLastname).isEqualTo("Vamshi RAO");


    }

    @Test(dependsOnMethods = {"Test_Create_Booking"}, priority = 5)
    public void Test_DELETE_Booking() {

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.log().all();


        response = requestSpecification.when().delete();

        validatableResponse = response.then().log().all().statusCode(201);


    }


}
