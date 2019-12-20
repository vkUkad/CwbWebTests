package com.cowabApiTests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Draft {
    @BeforeTest
    public void doPreconditions() {
        RestAssured.baseURI = "https://test-api.ajprodukter.se/middleware/v1/";
    }

    @Test(description = "Draft")
    public void login() {
        RequestSpecification httpsRequest = given().header("Ocp-Apim-Subscription-Key", "961a680d46844641bb43e75c27dacb87").body("[\"734671\"]");
        httpsRequest.contentType("application/json");
        Response response = httpsRequest.request(Method.POST, "availability/get/cse");

    }

}
