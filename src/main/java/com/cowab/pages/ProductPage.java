package com.cowab.pages;

import com.cowab.elements.Header;
import com.cowab.elements.Product;
import com.cowab.objects.User;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ProductPage extends BasePage {
    Product product = new Product();

    @Step("Click Add to wishlist button")
    public ProductPage clickAddToWishlistButton() {
        product.getBtnAddToWishlist().click();
        return this;
    }

    @Step("Fillout new wishlist name field")
    public ProductPage filloutNewWishlistNameField(User user) {
        String wishlistName = user.getEmail();
        wishlistName = wishlistName.replaceAll("@test.tt", "");
        wishlistName = wishlistName.replaceAll("test", "");
        product.getInputWishlistName().sendKeys("wishlist " + wishlistName);
        return this;
    }

    @Step("Delete imbox from product page")
    public ProductPage deleteImboxFromProductPage() {
        if ($("#imbox-container").exists()) {
            executeJavaScript("document.getElementById('imbox-container').remove();", "");
        }
        return new ProductPage();
    }

    @Step("Click Save button")
    public ProductPage clickSaveButton() {
        product.getBtnSave().click();
        return this;
    }
}
