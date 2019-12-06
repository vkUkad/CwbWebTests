package com.cowab.pages;

import com.cowab.elements.CheckoutFinalize;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.awt.*;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutFinalizePage extends CheckoutBasePage {

    CheckoutFinalize checkoutFinalize = new CheckoutFinalize();


    @Step("Check GDPR checkbox'")
    public CheckoutFinalizePage checkGDPR(WebDriver driver) {
        return this;
    }

    @Step("Check Private Policy checkbox'")
    public CheckoutFinalizePage checkPrivatePolicy() throws AWTException {
        clickOnTheElementByMouseOver(checkoutFinalize.getCheckboxPrivacyPolicy());
        return this;
    }

    @Step("Check Newsletter subscription checkbox")
    public CheckoutFinalizePage checkNewsletterSubscriptionCheckbox() throws AWTException {
        clickOnTheElementByMouseOver(checkoutFinalize.getCheckboxNewsletterSubscriptionUnclickable());
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
