package com.cowab.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class MyPages {
    private final SelenideElement textAreaNewsletter;
    private final SelenideElement tabShoppingList;

    public MyPages() {
        textAreaNewsletter = $("div[class='myaccount-page__col-content form-container p-top--15']");
        tabShoppingList = $("a[title='Inköpslistor']");
    }
}
