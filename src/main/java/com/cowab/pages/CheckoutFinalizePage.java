package com.cowab.pages;

import com.cowab.elements.CheckoutFinalize;
import io.qameta.allure.Step;

public class CheckoutFinalizePage extends CheckoutBasePage {

    CheckoutFinalize checkoutFinalize = new CheckoutFinalize();


    @Step("Check GDPR checkbox'")
    public CheckoutFinalizePage checkGDPR() {
        checkoutFinalize.getCheckboxGDPR().click();
        waitPageLoading();
        return this;
    }

    @Step("Check Private Policy checkbox'")
    public CheckoutFinalizePage checkPrivatePolicy() {
        checkoutFinalize.getCheckboxPrivatePolicy().click();
        waitPageLoading();
        return this;
    }

    @Step("Press continue button to go to Thank You page")
    public CheckoutThankYouPage gotoThankYouPage() {
        checkoutFinalize.getBtnSubmit().click();
        waitPageLoading();
        return new CheckoutThankYouPage();
    }

    @Step("Press continue button to go to Thank You page")
    public DibsPaymentPage gotoDibsPage() {
        checkoutFinalize.getBtnSubmit().click();
        waitPageLoading();
        return new DibsPaymentPage();
    }

}
