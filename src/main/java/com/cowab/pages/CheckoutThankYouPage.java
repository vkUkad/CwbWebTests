package com.cowab.pages;


import com.codeborne.selenide.Condition;
import com.cowab.elements.CheckoutThankYou;
import com.cowab.elements.Header;
import io.qameta.allure.Step;

public class CheckoutThankYouPage extends CheckoutBasePage {

    CheckoutThankYou checkoutThankYou = new CheckoutThankYou();

    @Step("Verify that thank you page is displayed")
    public CheckoutThankYouPage verifyThankYouPage() {
        checkoutThankYou.getThankYouPageHeader().shouldBe(Condition.visible);
        return this;
    }

    @Step("Open My Profile page")
    public MyPagesPage goToMyPages() {
        Header header = new Header();
        header.getBtnLoggedInUser().click();
        header.getBtnMyPages().click();
        return new MyPagesPage();
    }
}
