package com.cowab.elements;

import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$;

@Getter
public class ProductListing {

    private final ElementsCollection listProducts;
    private final ElementsCollection btnBuy;

    public ProductListing() {
        listProducts = $$(".product__item");
        btnBuy = $$(".js-buybtn .material-icons");
    }
}
