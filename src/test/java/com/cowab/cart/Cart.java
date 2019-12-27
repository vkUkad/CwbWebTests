package com.cowab.cart;

import com.codeborne.selenide.Configuration;
import com.cowab.pages.BasePage;
import com.cowab.testconfig.TestConfiguration;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.cowab.utils.Configuration.TESTING_URL_SE;

@Feature("Cart flow")
@Story("Cart flow")
public class Cart extends TestConfiguration {
    @BeforeTest
    public void doPreconditions() {
        Configuration.remote = "http://192.168.0.217:8080/wd/hub/";
        Configuration.driverManagerEnabled = false;

    }

    @Test(description = "Add product to the cart")
    //@Video
    public void openCart() {
      //  WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));

        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .openProductListingForQuery("bord")
                .addTheFirstProductToTheCart()
                .openCart()
                .verifyNumberOfProductsItCart(1);
    }

    @Test(description = "Check cart count indicator")
    //@Video
    public void verifyCartNumberIndicator() {
      //  WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .verifyNumberOnCartIcon("0")
                .openProductListingForQuery("bord")
                .addTheFirstProductToTheCart()
                .verifyNumberOnCartIcon("1")
                .openProductListingForQuery("matta")
                .addTheFirstProductToTheCart()
                .verifyNumberOnCartIcon("2");
    }

    @Test(description = "Change products quantity in a cart")
   //@Video
    public void changeProductQuantity() {
    //    WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .openProductListingForQuery("bord")
                .addTheFirstProductToTheCart()
                .openCart()
                .increaseProductQuantityFirst()
                .verifyCartPriceBlock()
                .decreaseProductQuantityFirst()
                .verifyCartPriceBlock()
                .removeProductFirst()
                .verifyNumberOfProductsItCart(0);

    }

    @Test(description = "Check Price behavior on cart")
    //@Video
    public void verifyPriceInTheBasket() {
    //    WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .verifyNumberOnCartIcon("0")
                .openProductListingForQuery("500251")
                .addTheFirstProductToTheCart()
                .openProductListingForQuery("bord")
                .addTheFirstProductToTheCart()
                .openCart()
                .verifyCartPriceBlock();
    }
}
