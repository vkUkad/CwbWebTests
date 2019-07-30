package com.cowab.pages;

import com.cowab.elements.ProductListing;
import io.qameta.allure.Step;

public class ProductListingPage extends BasePage {

    ProductListing productListing = new ProductListing();

    @Step("Verify that number of displayed products equals to '{x}'")
    public ProductListingPage verifyNumberOfDisplayedProducts(int x) {
        productListing.getListProducts().shouldHaveSize(x);
        return this;
    }

    @Step("Add the first product to the cart")
    public ProductListingPage addTheFirstProductToTheCart() {
        waitPageLoading();
        productListing.getBtnBuy().first().click();
        waitPageLoading();
        return this;
    }
}
