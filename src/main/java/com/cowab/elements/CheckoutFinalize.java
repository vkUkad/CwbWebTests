package com.cowab.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class CheckoutFinalize {

    private final SelenideElement checkboxGDPR;
    private final SelenideElement checkboxPrivacyPolicy;
    private final SelenideElement btnSubmit;
    private final SelenideElement blockCheckboxes;
    private final SelenideElement checkboxNewsletterSubscriptionUnclickable;

    public CheckoutFinalize() {
        checkboxGDPR = $("label.checkbox__label");
        blockCheckboxes = $("div[class='grid__cell 1/4--desk']");
        checkboxPrivacyPolicy = $(".checkbox__label[for=\"PrivacyPolicy\"]");
        btnSubmit = $(".js-continueButton");
        checkboxNewsletterSubscriptionUnclickable = $("#WantsNewsletter");
    }
}
