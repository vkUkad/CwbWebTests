package com.cowab.pages;


import com.codeborne.selenide.Condition;
import com.cowab.elements.CheckoutThankYou;
import io.qameta.allure.Step;

public class CheckoutThankYouPage extends CheckoutBasePage {

    CheckoutThankYou checkoutThankYou = new CheckoutThankYou();

    @Step("Verify that thank you page is displayed")
    public CheckoutThankYouPage verifyThankYouPage(){
        checkoutThankYou.getThankYouPageHeader().shouldBe(Condition.visible);
        return this;
    }
}
