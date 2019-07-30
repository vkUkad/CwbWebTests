package com.cowab.pages;

import com.cowab.elements.CheckoutLogin;
import com.cowab.elements.LoginPopup;
import com.cowab.objects.User;
import io.qameta.allure.Step;

public class CheckoutLoginPage extends CheckoutBasePage {

    CheckoutLogin checkoutLogin = new CheckoutLogin();
    LoginPopup checkoutRegistration = new LoginPopup();

    @Step("Register new private user with the mail: {user.email}")
    public CheckoutDeliveryPage registerPrivateUserCheckout(User user) {
        waitPageLoading();
        checkoutLogin.getBtnRegistration().click();
        checkoutRegistration.getRadioPrivate().click();
        checkoutRegistration.getFieldEmail().sendKeys(user.getEmail());
        checkoutRegistration.getFieldEmailRepeat().sendKeys(user.getEmail());
        checkoutRegistration.getFieldRegisterPassword().sendKeys(user.getPassword());
        checkoutRegistration.getFieldRegisterPasswordRepeat().sendKeys(user.getPassword());
        checkoutRegistration.getBtnContinueRegistration().click();
        waitPageLoading();
        checkoutRegistration.getFieldUserName().sendKeys(user.getUserName());
        checkoutRegistration.getFieldUserLastName().sendKeys(user.getUserLastName());
        checkoutRegistration.getFieldUserMobile().sendKeys(user.getUserMobile());
        checkoutRegistration.getFieldAddress().sendKeys(user.getAddress());
        checkoutRegistration.getFieldPostCode().sendKeys(user.getPostCode());
        checkoutRegistration.getFieldCity().sendKeys(user.getCity());
        checkoutRegistration.getFieldPhone().sendKeys(user.getPhone());
        checkoutRegistration.getCheckboxSecurityPolicy().click();
        checkoutRegistration.getBtnContinueRegistration().click();
        waitPageLoading();
        return new CheckoutDeliveryPage();
    }

    @Step("Register new company user with the mail: {user.email}")
    public CheckoutDeliveryPage registerCompanyUserCheckout(User user) {
        waitPageLoading();
        checkoutLogin.getBtnRegistration().click();
        checkoutRegistration.getRadioCompany().click();
        checkoutRegistration.getFieldEmail().sendKeys(user.getEmail());
        checkoutRegistration.getFieldEmailRepeat().sendKeys(user.getEmail());
        checkoutRegistration.getFieldRegisterPassword().sendKeys(user.getPassword());
        checkoutRegistration.getFieldRegisterPasswordRepeat().sendKeys(user.getPassword());
        checkoutRegistration.getBtnContinueRegistration().click();
        waitPageLoading();
        checkoutRegistration.getFieldOrganisationNumber().sendKeys(user.getOrganisationNumber());
        checkoutRegistration.getFieldCompanyName().sendKeys(user.getCompanyName());
        checkoutRegistration.getFieldUserName().sendKeys(user.getUserName());
        checkoutRegistration.getFieldUserLastName().sendKeys(user.getUserLastName());
        checkoutRegistration.getFieldUserMobile().sendKeys(user.getUserMobile());
        checkoutRegistration.getFieldAddress().sendKeys(user.getAddress());
        checkoutRegistration.getFieldPostCode().sendKeys(user.getPostCode());
        checkoutRegistration.getFieldCity().sendKeys(user.getCity());
        checkoutRegistration.getFieldPhone().sendKeys(user.getPhone());
        checkoutRegistration.getCheckboxSecurityPolicy().click();
        checkoutRegistration.getBtnContinueRegistration().click();
        waitPageLoading();
        return new CheckoutDeliveryPage();
    }

    @Step("Login on checkout page with the login: {login}")
    public CheckoutDeliveryPage loginOnCheckout(String login, String password) {
        checkoutLogin.getFieldLogin().sendKeys(login);
        checkoutLogin.getFieldPassword().sendKeys(password);
        checkoutLogin.getBtnLogin().click();
        waitPageLoading();
        deleteImbox();
        return new CheckoutDeliveryPage();
    }
}
