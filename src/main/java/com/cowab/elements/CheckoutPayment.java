package com.cowab.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CheckoutPayment {

    private final SelenideElement radioInvoice;
    private final SelenideElement fieldInvoiceMail;
    private final SelenideElement fieldInvoiceMailLabel;
    private final SelenideElement btnAddInvoiceAddress;
    private final SelenideElement fieldCompanyName;
    private final SelenideElement fieldCompanyAddress;
    private final SelenideElement fieldZipCode;
    private final SelenideElement fieldCity;
    private final SelenideElement fieldInvoiceNote;
    private final SelenideElement btnSubmit;


    public CheckoutPayment() {
        radioInvoice = $("label[for=\"PaymentInvoice\"]");
        fieldInvoiceMail = $("#invoicePdfEmail");
        fieldInvoiceMailLabel = $("label[for=\"invoicePdfEmail\"]");
        btnAddInvoiceAddress = $(".js-newaddress");
        fieldCompanyName = $("#CompanyName");
        fieldCompanyAddress = $("#Line1");
        fieldCity = $("#City");
        fieldZipCode = $("#ZipCode");
        fieldInvoiceNote = $(".invoiceNote");
        btnSubmit = $(".btn.mobile-to-pc-hidden");
    }
}
