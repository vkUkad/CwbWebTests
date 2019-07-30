package com.cowab.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CheckoutHeader {
    
    private final SelenideElement linkNavMyInfo;


    public CheckoutHeader() {
        linkNavMyInfo = $(".mobile-to-pc-hidden > .stepper__step--login");
    }
}
