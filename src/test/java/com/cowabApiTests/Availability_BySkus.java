package com.cowabApiTests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Availability_BySkus {
    /**
     * https://ajprodukter.portal.azure-api.net/docs/services/aj-produkter-middleware/operations/Availability_BySkus
     */
    @BeforeTest
    public void doPreconditions() {
        RestAssured.baseURI = "https://test-api.ajprodukter.se/middleware/v1/";
    }

    @Test(description = "Validate if response is 200")
    public void validate200Response_AvailabilityBySkus() {
        RequestSpecification httpsRequest = given().header("Ocp-Apim-Subscription-Key", "961a680d46844641bb43e75c27dacb87").body("[\"734671\"]");
        httpsRequest.contentType("application/json");
        Response response = httpsRequest.request(Method.POST, "availability/get/cse");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    //todo: update functionality
    @Test(description = "Validate specific fields response: ")
    public void validateSpecificFields_AvailabilityBySkus() {

    }

    @Test(description = "Validate Json schema")
    public void validateJsonSchema_AvailabilityBySkus() throws ParseException {
        RequestSpecification httpsRequest = given().header("Ocp-Apim-Subscription-Key", "961a680d46844641bb43e75c27dacb87").body("[\"734671\"]");
        httpsRequest.contentType("application/json");
        Response response = httpsRequest.request(Method.POST, "availability/get/cse");

       // response.then().assertThat().body(matchesJsonSchemaInClasspath("jsonSchemaAvailability_BySkus.json"));
        response.then().assertThat().body(matchesJsonSchemaInClasspath("jsonSchemaAvailability_BySkusUpdatedAccordingToResponse.json"));

    }
}
