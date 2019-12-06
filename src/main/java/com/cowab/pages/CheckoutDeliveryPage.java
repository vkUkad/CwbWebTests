package com.cowab.pages;

import com.codeborne.selenide.Condition;
import com.cowab.elements.CheckoutDelivery;
import io.qameta.allure.Step;

public class CheckoutDeliveryPage extends CheckoutBasePage {

    CheckoutDelivery checkoutDelivery = new CheckoutDelivery();

    @Step("Add new delivery address for Company")
    public CheckoutDeliveryPage addNewDeliveryAddressCompany(String companyName, String address, String postcode, String city) {
        checkoutDelivery.getBtnAddNewDeliveryAddress().waitUntil(Condition.visible, 3000);
        checkoutDelivery.getBtnAddNewDeliveryAddress().click();
        checkoutDelivery.getFieldCompanyName().sendKeys(companyName);
        checkoutDelivery.getFieldCompanyAddress().sendKeys(address);
        checkoutDelivery.getFieldZipCode().sendKeys(postcode);
        checkoutDelivery.getFieldCity().sendKeys(city);
        return this;
    }

    @Step("Add new delivery address for Private")
    public CheckoutDeliveryPage addNewDeliveryAddressPrivate(String firstName, String lastName, String address, String postcode, String city) {
        checkoutDelivery.getBtnAddNewDeliveryAddress().waitUntil(Condition.visible, 3000);
        checkoutDelivery.getBtnAddNewDeliveryAddress().click();
        checkoutDelivery.getFieldUserFirstName().sendKeys(firstName);
        checkoutDelivery.getFieldUserLastName().sendKeys(lastName);
        checkoutDelivery.getFieldCompanyAddress().sendKeys(address);
        checkoutDelivery.getFieldZipCode().sendKeys(postcode);
        checkoutDelivery.getFieldCity().sendKeys(city);
        return this;
    }

    @Step("Add phone notification for number: {phone}")
    public CheckoutDeliveryPage addPhoneNotification(String phone, String name) {
        if (!checkoutDelivery.getCheckboxPhoneNotificationFromBeforeLabel().is(Condition.checked)) {
            checkoutDelivery.getCheckboxPhoneNotification().click();
            waitPageLoading();
            checkoutDelivery.getFieldPhoneNumber().sendKeys(phone);
            checkoutDelivery.getFieldName().sendKeys(name);
        }
        return this;
    }

    @Step("Add label: '{label}'")
    public CheckoutDeliveryPage addOrderLabel(String label) {
        if (!checkoutDelivery.getCheckboxOrderLabelFromBeforeLabel().is(Condition.checked)) {
            checkoutDelivery.getCheckboxOrderLabel().click();
        }
        waitPageLoading();
        checkoutDelivery.getFieldOrderLabel().sendKeys(label);
        return this;
    }

    @Step("Press continue button to go to payment page")
    public CheckoutPaymentPage gotoPaymentPage() {
        checkoutDelivery.getBtnSubmit().click();
        waitPageLoading();
        deleteImbox();
        return new CheckoutPaymentPage();
    }

    @Step("Verify that delivery block is displayed")
    public CheckoutDeliveryPage verifyDeliveryPage() {
        checkoutDelivery.getBlockDelivery().shouldBe(Condition.visible);
        return this;
    }

}
