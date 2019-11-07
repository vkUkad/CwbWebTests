package com.cowab.pages;

import com.codeborne.selenide.Condition;
import com.cowab.elements.MyPages;
import io.qameta.allure.Step;

public class MyPagesPage extends BasePage {
    MyPages myPages = new MyPages();

    @Step("Check if valid newsletter state appears after update")
    public void checkIfExpectedStateAppearsAfterSubscription() {
        myPages.getTextAreaNewsletter().shouldHave(Condition.text("Du är prenumerant av Cowabs nyhetsbrev. (Newsletter)"));
    }

    @Step("Switch tab to Shopping lists")
    public MyPagesPage switchTabToShoppingLists() {
        myPages.getTabShoppingList().click();
        return this;
    }

    @Step("Verify that expected Newsletter subscription state appears on my pages")
    public MyPagesPage verifyIfExpectedStateAppearsBeforeSubscription() {
        MyPages myPages = new MyPages();
        myPages.getTextAreaNewsletter().shouldHave(Condition.text("Det finns flera goda skäl att prenumerera på vårt nyhetsbrev:\n" +
                "\n" +
                " \n" +
                "\n" +
                "De senaste nyheterna\n" +
                "Andra erbjudanden!"));
        return this;
    }
}
