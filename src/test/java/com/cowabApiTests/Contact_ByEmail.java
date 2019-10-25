package com.cowabApiTests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

/**
 * https://ajprodukter.portal.azure-api.net/docs/services/aj-produkter-middleware/operations/Contact_ByEmail
 */
public class Contact_ByEmail {
    @BeforeTest
    public void doPreconditions() {
        RestAssured.baseURI = "https://test-api.ajprodukter.se/middleware/v1/";
    }

    @Test(description = "Validate if response is 200")
    public void validate200Response_ContactByEmail() {
        RequestSpecification httpsRequest = given().header("Ocp-Apim-Subscription-Key", "961a680d46844641bb43e75c27dacb87").body("\"apitestsebus@mailinator.com\"");
        Response response = httpsRequest.request(Method.GET, "contact/get/customers/cse");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    //todo: update functionality
    @Test(description = "Validate specific fields response: ")
    public void validateSpecificFields_ContactByEmail() {

    }

    @Test(description = "Validate Json schema")
    public void validateJsonSchema_ContactsByEmail() {
        RequestSpecification httpsRequest = given().header("Ocp-Apim-Subscription-Key", "961a680d46844641bb43e75c27dacb87").body("\"apitestsebus@mailinator.com\"");
        Response response = httpsRequest.request(Method.GET, "contact/get/customers/cse");
        System.out.println(response.getBody().asString());
        response.then().assertThat().body(matchesJsonSchemaInClasspath("jsonSchemaContact_ByEmail.json"));
    }
}
