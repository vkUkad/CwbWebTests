package com.cowab.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CheckoutDelivery {

    private final SelenideElement btnAddNewDeliveryAddress;
    private final SelenideElement fieldCompanyName;
    private final SelenideElement labelUserFirstName;
    private final SelenideElement fieldUserFirstName;
    private final SelenideElement labelUserLastName;
    private final SelenideElement fieldUserLastName;
    private final SelenideElement fieldCompanyAddress;
    private final SelenideElement fieldZipCode;
    private final SelenideElement fieldCity;
    private final SelenideElement checkboxPhoneNotification;
    private final SelenideElement checkboxPhoneNotificationFromBeforeLabel;
    private final SelenideElement fieldPhoneNumber;
    private final SelenideElement fieldName;
    private final SelenideElement checkboxOrderLabel;
    private final SelenideElement checkboxOrderLabelFromBeforeLabel;
    private final SelenideElement fieldOrderLabel;
    private final SelenideElement btnSubmit;
    private final SelenideElement blockDelivery;

    public CheckoutDelivery() {
        btnAddNewDeliveryAddress = $(".js-newaddress");
        fieldCompanyName = $("#CompanyName");
        labelUserFirstName = $(".form-group__label[for=\"FirstName\"]");
        fieldUserFirstName = $("#FirstName");
        labelUserLastName = $(".form-group__label[for=\"LastName\"]");
        fieldUserLastName = $("#LastName");
        fieldCompanyAddress = $("#Line1");
        fieldCity = $("#City");
        fieldZipCode = $("#ZipCode");
        checkboxPhoneNotification = $("label[for=\"telefonavisering\"]");
        checkboxPhoneNotificationFromBeforeLabel = $("#telefonavisering");
        fieldPhoneNumber = $("#PhoneNumber");
        fieldName = $("#Name");
        checkboxOrderLabel = $("label[for=\"OrderLabelCheckBox\"]");
        checkboxOrderLabelFromBeforeLabel = $("#OrderLabelCheckBox");
        fieldOrderLabel = $("#orderlabel");
        btnSubmit = $(".delivery__submit .btn");
        blockDelivery = $(".delivery");
    }
}
