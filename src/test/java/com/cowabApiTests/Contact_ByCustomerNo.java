package com.cowabApiTests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Contact_ByCustomerNo {
    /**
    https://ajprodukter.portal.azure-api.net/docs/services/aj-produkter-middleware/operations/Contact_ByCustomerNo
     */
    @BeforeTest
    public void doPreconditions() {
        RestAssured.baseURI = "https://test-api.ajprodukter.se/middleware/v1/";
    }

    @Test(description = "Verify if response is 200")
    public void validate200Response_ContactByCustomerNo() {
        RequestSpecification httpsRequest = RestAssured.given().header("Ocp-Apim-Subscription-Key", "961a680d46844641bb43e75c27dacb87");
        Response response = httpsRequest.request(Method.GET, "contact/get/cse/49003");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Validate specific fields response: 'Active', 'CustomerNo', 'Type=email'")
    public void validateSpecificFields_ContactByCustomerNo() {
        RequestSpecification httpsRequest = RestAssured.given().header("Ocp-Apim-Subscription-Key", "961a680d46844641bb43e75c27dacb87");
        Response response = httpsRequest.request(Method.GET, "contact/get/cse/49003");
        JsonPath jsonPath = response.jsonPath();

        ArrayList active = jsonPath.get("Active");
        for (Object o : active) {
            Assert.assertEquals(o, true);
        }

        ArrayList customerNo = jsonPath.get("CustomerNo");
        for (Object o : customerNo) {
            Assert.assertEquals(o, "49003");
        }

        ArrayList value = jsonPath.get("Communications");
        for (Object o : value) {
            boolean passed = false;
            ArrayList oArray = (ArrayList) o;
            for (Object object : oArray) {
                if (object.toString().contains("Type=email")) {
                    {
                        Assert.assertEquals(object.toString().contains("apitestsebus@mailinator.com"), true);
                        passed = true;
                    }
                }
            }
            Assert.assertEquals(passed, true);
        }
    }

    @Test(description = "Validate Json schema")
    public void validateJSonSchema() {
        RequestSpecification httpsRequest = RestAssured.given().header("Ocp-Apim-Subscription-Key", "961a680d46844641bb43e75c27dacb87");
        Response response = httpsRequest.request(Method.GET, "contact/get/cse/49003");
        System.out.println(response.getBody().asString());
        response.then().body(matchesJsonSchemaInClasspath("jsonSchemaContact_ByCustomerNoUpdatedAccordingToResponse.json"));
    }
}
