package com.cowab.pages;

import com.cowab.elements.CheckoutHeader;
import com.cowab.elements.CheckoutPayment;
import io.qameta.allure.Step;

public class CheckoutPaymentPage extends CheckoutBasePage{

    CheckoutPayment checkoutPayment = new CheckoutPayment();

    @Step("Select 'Invoice' payment type")
    public CheckoutPaymentPage selectInvoicePayment(){
        new CheckoutHeader().getLinkNavMyInfo().hover();
        checkoutPayment.getRadioInvoice().click();
        return this;
    }

    @Step("Fill 'Invoice' mail for the new customer")
    public CheckoutPaymentPage fillInvoiceMail(String email){
        checkoutPayment.getFieldInvoiceMailLabel().click();
        checkoutPayment.getFieldInvoiceMail().sendKeys(email);
        return this;
    }

    @Step("Add new address")
    public CheckoutPaymentPage addNewInvoiceAddress(String companyName, String address, String postcode, String city) {
        checkoutPayment.getBtnAddInvoiceAddress().click();
        checkoutPayment.getFieldCompanyName().sendKeys(companyName);
        checkoutPayment.getFieldCompanyAddress().sendKeys(address);
        checkoutPayment.getFieldZipCode().sendKeys(postcode);
        checkoutPayment.getFieldCity().sendKeys(city);
        return this;
    }

    @Step("Fill 'Invoice note'")
    public CheckoutPaymentPage fillInvoiceNote(String note){
        checkoutPayment.getFieldInvoiceMail().sendKeys(note);
        return this;
    }

    @Step("Press continue button to go to payment page")
    public CheckoutFinalizePage gotoFinalizePage() {
        checkoutPayment.getBtnSubmit().click();
        waitPageLoading();
        deleteImbox();
        return new CheckoutFinalizePage();
    }
}
