package com.cowab.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CheckoutFinalize {

    private final SelenideElement checkboxGDPR;
    private final SelenideElement checkboxPrivatePolicy;
    private final SelenideElement btnSubmit;



    public CheckoutFinalize() {
        checkboxGDPR = $(".checkbox__label[for=\"GToP\"]");
        checkboxPrivatePolicy = $(".checkbox__label[for=\"PrivacyPolicy\"]");
        btnSubmit = $(".js-continueButton");
    }
}
