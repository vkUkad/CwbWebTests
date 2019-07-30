package com.cowab.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CheckoutThankYou {

    private final SelenideElement thankYouPageHeader;

    public CheckoutThankYou() {
        thankYouPageHeader = $(".confirmation-page__header .c");
    }
}
