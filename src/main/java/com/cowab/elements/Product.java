package com.cowab.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class Product {
    private final ElementsCollection collectionAddTowishlist;
    private final SelenideElement inputWishlistName;
    private final SelenideElement btnAddToWishlist;
    private final ElementsCollection collectionAddToWishlistSave;
    private final SelenideElement btnSave;

    public Product() {
        collectionAddTowishlist = $$("a[data-modal-id='addWishlistModal']");
        btnAddToWishlist = collectionAddTowishlist.get(0);
        inputWishlistName = $("#newWishlistName");
        collectionAddToWishlistSave = $$("button[class='btn btn--primary-orange btn--middle submit-btn']");
        btnSave = collectionAddToWishlistSave.get(1);
    }
}
