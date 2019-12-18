package com.cowab.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class MyPages {
    private final SelenideElement textAreaNewsletter;
    private final SelenideElement tabShoppingList;
    private final ElementsCollection elementCollectionTextCustomerNo;
    private final SelenideElement textCustomerNo;
    private final SelenideElement btnShare;
    private final SelenideElement inputRecieverEmailAddress;

    public MyPages() {
        textAreaNewsletter = $("div[class='myaccount-page__col-content form-container p-top--15']");
        tabShoppingList = $("a[title='Inköpslistor']");
        elementCollectionTextCustomerNo = $$("div.myaccount-page__col-content p");
        textCustomerNo = elementCollectionTextCustomerNo.get(0);
        btnShare = $("a[class='js-share-btn myaccount-table__icon js-open-modal js-open-users-modal']");
        inputRecieverEmailAddress = $("label[for='WishListEmail']");
    }
}
