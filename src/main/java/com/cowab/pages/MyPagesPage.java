package com.cowab.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.cowab.elements.MyPages;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class MyPagesPage extends BasePage {
    MyPages myPages = new MyPages();

    @Step("Check if valid newsletter state appears after update")
    public void checkIfExpectedStateAppearsAfterSubscription() {
        waitPageLoading();
        String customerNo = myPages.getTextCustomerNo().getText();
        if (WebDriverRunner.url().contains("test")) {
            RestAssured.baseURI = "https://test-api.ajprodukter.se/middleware/v1/";
        } else if (WebDriverRunner.url().contains("preprod")) {
            RestAssured.baseURI = "https://preprod-api.ajprodukter.se/middleware/v1/";
        }
        RequestSpecification httpsRequest = RestAssured.given().header("Ocp-Apim-Subscription-Key", "961a680d46844641bb43e75c27dacb87");
        Response response = httpsRequest.request(Method.GET, "contact/get/cse/" + customerNo);
        JsonPath jsonPath = response.jsonPath();
        jsonPath.get("");
        //myPages.getTextAreaNewsletter().shouldHave(Condition.text("Du är prenumerant av Cowabs nyhetsbrev. (Newsletter)"));

    }

    @Step("Switch tab to Shopping lists")
    public MyPagesPage switchTabToShoppingLists() {
        myPages.getTabShoppingList().click();
        return this;
    }

    @Step("Verify that expected Newsletter subscription state appears on my pages")
    public MyPagesPage verifyIfExpectedStateAppearsBeforeSubscription() {
        MyPages myPages = new MyPages();
        myPages.getTextAreaNewsletter().shouldHave(Condition.text("Det finns flera goda skäl att prenumerera på vårt nyhetsbrev:\n" +
                "\n" +
                " \n" +
                "\n" +
                "De senaste nyheterna\n" +
                "Andra erbjudanden!"));
        return this;
    }
}
