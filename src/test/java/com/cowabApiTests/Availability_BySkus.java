package com.cowabApiTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Feature("API test")
@Story("API test")
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

    @Test(description = "Validate specific fields response: itemNumber")
    public void validateSpecificFields_AvailabilityBySkus() {
        RequestSpecification httpsRequest = given().header("Ocp-Apim-Subscription-Key", "961a680d46844641bb43e75c27dacb87").body("[\"734671\"]");
        httpsRequest.contentType("application/json");
        Response response = httpsRequest.request(Method.POST, "availability/get/cse");
        JsonPath jsonPath = response.jsonPath();
        ArrayList items = jsonPath.get("Items");
        for (Object o : items) {
            if (o.toString().contains("ItemNumber")) {
                Assert.assertEquals(o.toString().contains("734671"), true);
            }
        }
    }

    @Test(description = "Validate Json schema")
    public void validateJsonSchema_AvailabilityBySkus() throws ParseException {
        RequestSpecification httpsRequest = given().header("Ocp-Apim-Subscription-Key", "961a680d46844641bb43e75c27dacb87").body("[\"734671\"]");
        httpsRequest.contentType("application/json");
        Response response = httpsRequest.request(Method.POST, "availability/get/cse");
        System.out.println(response.getBody().asString());
        response.then().assertThat().body(matchesJsonSchemaInClasspath("jsonSchemaAvailability_BySkusUpdatedAccordingToResponse.json"));
    }
}
