package com;

import com.codeborne.selenide.Configuration;
import com.cowab.data_generator.UserGenerator;
import com.cowab.objects.User;
import com.cowab.pages.BasePage;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.net.MalformedURLException;

import static com.cowab.utils.Configuration.TESTING_URL_SE;

public class Draft {
    @BeforeTest
    public void doPreconditions() {
        Configuration.remote = "http://192.168.0.217:8080/wd/hub/";
        Configuration.driverManagerEnabled = false;
    }

    @Test(description = "Checkout with new Company user")
    public void checkoutNewCompany() throws AWTException {
        User user = UserGenerator.generateUserSE();

        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .openProductListingForQuery("bord")
                .addTheFirstProductToTheCart()
                .openCart()
                .goToLoginCheckout()
                .registerCompanyUserCheckout(user)
                .addNewDeliveryAddressCompany("TestCompany", "TestApi address 1", "12345", "TestCity")
                .addPhoneNotification("+46712345671", "TestPhone")
                .addOrderLabel("TEST ORDER IGNORE IT")
                .gotoPaymentPage()
                .selectInvoicePayment()
                .fillInvoiceMail("testMail@test.test")
                .addNewInvoiceAddress("TestCompany", "TestApi address 1", "12345", "TestCity")
                .fillInvoiceNote("TestApi note")
                .gotoFinalizePage()
                .checkPrivatePolicy()
                .gotoThankYouPage()
                .verifyThankYouPage();
    }
}

