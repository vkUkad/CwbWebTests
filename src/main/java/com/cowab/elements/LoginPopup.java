package com.cowab.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class LoginPopup {

    private final SelenideElement modalSignIn;
    private final SelenideElement fieldLogin;
    private final SelenideElement fieldPassword;
    private final SelenideElement btnLogin;
    private final SelenideElement btnRegister;
    private final SelenideElement radioPrivate;
    private final SelenideElement radioCompany;
    private final SelenideElement fieldEmail;
    private final SelenideElement fieldEmailRepeat;
    private final SelenideElement fieldRegisterPassword;
    private final SelenideElement fieldRegisterPasswordRepeat;
    private final SelenideElement btnContinueRegistration;
    private final SelenideElement fieldOrganisationNumber;
    private final SelenideElement fieldCompanyName;
    private final SelenideElement fieldUserName;
    private final SelenideElement fieldUserLastName;
    private final SelenideElement fieldUserMobile;
    private final SelenideElement fieldAddress;
    private final SelenideElement fieldPostCode;
    private final SelenideElement fieldCity;
    private final SelenideElement fieldPhone;
    private final SelenideElement checkboxSecurityPolicy;

    public LoginPopup() {
        modalSignIn = $("#signInModal");
        fieldLogin = $("#EmailPopup");
        fieldPassword = $("#PasswordPopup");
        btnLogin = $(".js-login .btn");
        btnRegister = $(".btn.js-open-registration");
        radioPrivate = $(".radio__label[for=\"PrivateCustomer\"]");
        radioCompany = $(".radio__label[for=\"CompanyCustomer\"]");
        fieldEmail = $("#registerEmail");
        fieldEmailRepeat = $("#registerEmailRepeat");
        fieldRegisterPassword = $("#registerPassword");
        fieldRegisterPasswordRepeat = $("#registerPasswordRepeat");
        btnContinueRegistration = $(".js-continueButton");
        fieldOrganisationNumber = $("#OrganizationNumber");
        fieldCompanyName = $("#CompanyName");
        fieldUserName = $("#FirstName");
        fieldUserLastName = $("#LastName");
        fieldUserMobile = $("#PhoneNumber");
        fieldAddress = $("#Line1");
        fieldPostCode = $("#ZipCode");
        fieldCity = $("#City");
        fieldPhone = $("#Phone2");
        checkboxSecurityPolicy = $(".checkbox__label[for=\"SecurityPolicy\"]");
    }
}
