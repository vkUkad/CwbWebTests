package com.cowab.pages;


import com.codeborne.selenide.Condition;
import com.cowab.elements.CheckoutThankYou;
import com.cowab.elements.DibsPayment;
import io.qameta.allure.Step;

public class DibsPaymentPage extends CheckoutBasePage {

    DibsPayment dibsPayment = new DibsPayment();

    @Step("Pay with MasterCard")
    public CheckoutThankYouPage confirmOrderWithMasterCard(){
        dibsPayment.getBtnMasterCard().click();
        dibsPayment.getFieldCardNumber().sendKeys("5100100000000000");
        dibsPayment.getFieldExpiredMonth().sendKeys("06");
        dibsPayment.getFieldExpiredYear().sendKeys("24");
        dibsPayment.getFieldCVV().sendKeys("684");
        dibsPayment.getBtnSubmit().click();

        return new CheckoutThankYouPage();
    }
}
