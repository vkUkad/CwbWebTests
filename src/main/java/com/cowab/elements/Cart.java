package com.cowab.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class Cart {

    private final ElementsCollection listItemsInCart;
    private final String locatorSubtract;
    private final String locatorAdd;
    private final String locatorQuantity;
    private final String locatorDelete;
    private final String locatorPrice;
    private final String locatorTotalPrice;
    private final SelenideElement labelSubtotal;
    private final SelenideElement labelDelivery;
    private final SelenideElement labelMoms;
    private final SelenideElement labelTotalPrice;
    private final SelenideElement labelTotalWithoutMoms;
    private final SelenideElement btnGoToCheckout;


    public Cart() {
        listItemsInCart = $$(".item-row.js-item-row");
        locatorSubtract = ".subtract";
        locatorAdd = ".add";
        locatorQuantity = ".js-quantity";
        locatorDelete = ".delete .js-deletearticle";
        locatorPrice = ".placed-price>span";
        locatorTotalPrice = ".total-price.js-total-price";
        labelSubtotal = $("span.js-cart-subtotal");
        labelDelivery = $("div.summary-content > div:nth-child(2) > span:nth-child(2)");
        labelMoms = $("div.summary-content > div:nth-child(3) > span:nth-child(2)");
        labelTotalWithoutMoms = $(".js-cart-total-extax");
        labelTotalPrice = $(".js-cart-total");
        btnGoToCheckout = $(".cart-footer .btn.btn--primary-orange");
    }
}
