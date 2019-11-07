package com.cowab.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class Header {

    private final SelenideElement btnLogin;
    private final SelenideElement btnLogout;
    private final SelenideElement btnCompany;
    private final SelenideElement loader;
    private final SelenideElement searchIcon;
    private final SelenideElement fieldSearch;
    private final SelenideElement iconLoading;
    private final SelenideElement searchAsYourType;
    private final SelenideElement btnShowAll;
    private final SelenideElement btnCart;
    private final SelenideElement labelCartCount;
    private final ElementsCollection listFoundProducts;
    private final ElementsCollection listCategory;
    private final SelenideElement btnLoggedInUser;
    private final SelenideElement btnMyPages;

    public Header() {
        btnLogin = $(".logged-link .login");
        btnLogout = $(".account-modal a[href^=\"/Login/SignOut\"]");
        btnCompany = $(".btn[data-visitor-type=\"Company\"]");
        loader = $("#ajax-loader .spinner");
        searchIcon = $(".search__item");
        fieldSearch = $("#search");
        iconLoading = $(".loading--icon");
        searchAsYourType = $(".navbar__search--content");
        btnShowAll = $(".product-search-all");
        btnCart = $(".btn.cart");
        labelCartCount = $(".cart span .cart-count");
        listFoundProducts = $$(".item");
        listCategory = $$(".content--hit > ul > li");
        btnLoggedInUser = $("li.logged-link");
        btnMyPages = $("div.account-modal__main-btn-holder");
    }
}
