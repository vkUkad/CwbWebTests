package com.cowab.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CheckoutLogin {

    private final SelenideElement fieldLogin;
    private final SelenideElement fieldPassword;
    private final SelenideElement btnLogin;
    private final SelenideElement btnRegistration;


    public CheckoutLogin() {
        fieldLogin = $("#Email");
        fieldPassword = $("#Password");
        btnLogin = $(".submit-btn .btn");
        btnRegistration = $(".js-desktop-register");
    }
}
