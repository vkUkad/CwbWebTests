package com.cowab.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class DibsPayment {

    private final SelenideElement btnMasterCard;
    private final SelenideElement btnVisa;
    private final SelenideElement fieldCardNumber;
    private final SelenideElement fieldExpiredMonth;
    private final SelenideElement fieldExpiredYear;
    private final SelenideElement fieldCVV;
    private final SelenideElement btnSubmit;

    public DibsPayment() {
        btnMasterCard = $("#paytypeLink_MC");
        btnVisa = $("#paytypeLink_VISA");
        fieldCardNumber = $("#auth_cardno");
        fieldExpiredMonth = $("#auth_expmon");
        fieldExpiredYear = $("#auth_expyear");
        fieldCVV = $("#auth_cvc");
        btnSubmit = $("#btnAuthSubmit");
    }
}
