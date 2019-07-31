package com.cowab.checkout;

import com.codeborne.selenide.WebDriverRunner;
import com.cowab.data_generator.UserGenerator;
import com.cowab.objects.User;
import com.cowab.pages.BasePage;
import com.cowab.testconfig.TestConfiguration;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.cowab.utils.Configuration.TESTING_URL_SE;
import static com.cowab.utils.driver.MyDriverManager.createWebDriver;

@Feature("Checkout")
@Story("Checkout flow")
public class Checkout extends TestConfiguration {

    @Test(description = "Checkout with new Company user")
    public void checkoutNewCompany() {
        User user = UserGenerator.generateUserSE();
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .openProductListingForQuery("bord")
                .addTheFirstProductToTheCart()
                .openCart()
                .goToCheckout()
                .registerCompanyUserCheckout(user)
                .addNewDeliveryAddressCompany("TestCompany", "Test address 1", "12345", "TestCity")
                .addPhoneNotification("+46712345671", "TestPhone")
                .addOrderLabel("TEST ORDER IGNORE IT")
                .gotoPaymentPage()
                .selectInvoicePayment()
                .fillInvoiceMail("testMail@test.test")
                .addNewInvoiceAddress("TestCompany", "Test address 1", "12345", "TestCity")
                .fillInvoiceNote("Test note")
                .gotoFinalizePage()
                .checkGDPR()
                .checkPrivatePolicy()
                .gotoThankYouPage()
                .verifyThankYouPage();
    }

    @Test(description = "Checkout with new Private user")
    public void checkoutNewPrivate() {
        User user = UserGenerator.generateUserSE();
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .openProductListingForQuery("bord")
                .addTheFirstProductToTheCart()
                .openCart()
                .goToCheckout()
                .registerPrivateUserCheckout(user)
                .addNewDeliveryAddressPrivate("TestFirstName", "TestLastName", "Test address 1", "12345", "TestCity")
                .addPhoneNotification("+46712345671", "TestPhone")
                .addOrderLabel("TEST ORDER IGNORE IT")
                .gotoPaymentPage()
                .gotoFinalizePage()
                .checkGDPR();
//                .checkPrivatePolicy()
//                .gotoDibsPage()
//                .confirmOrderWithMasterCard()
//                .verifyThankYouPage();
    }


    @Test(description = "Login on checkout with existing Company user")
    public void checkoutExistingCompany() {
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .openProductListingForQuery("bord")
                .addTheFirstProductToTheCart()
                .openCart()
                .goToCheckout()
                .loginOnCheckout("vzotke@gmail.com", "q1w2e3r4T%")
//                .loginOnCheckout("vlad.zotke@ajprodukter.se", "q1w2e3r4T%")
                .verifyDeliveryPage();
    }

    @Test(description = "Login on checkout with existing Private user")
    public void checkoutExistingPrivate() {
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .openProductListingForQuery("bord")
                .addTheFirstProductToTheCart()
                .openCart()
                .goToCheckout()
//                .loginOnCheckout("testcowabprivate@gmail.com", "q1w2e3r4T%")
                .loginOnCheckout("vzotketest@gmail.com", "q1w2e3r4T%")
                .verifyDeliveryPage();
    }

//    @Test(description = "Login on checkout with existing Private user")
//    public void checkoutExistingPrivateFull() {
//        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
//        new BasePage().openMainPage(TESTING_URL_SE)
//                .selectCompanyVisitorType()
//                .openProductListingForQuery("40046")
//                .addTheFirstProductToTheCart()
//                .openCart()
//                .goToCheckout()
//                .loginOnCheckout("vzotketest@gmail.com", "q1w2e3r4T%")
//                .addNewDeliveryAddressPrivate("TestFirstName", "TestLastName", "Test address 1", "12345", "TestCity")
//                .addPhoneNotification("+46712345671", "TestPhone")
//                .addOrderLabel("TEST ORDER IGNORE IT")
//                .gotoPaymentPage()
//                .gotoFinalizePage();
//                .checkGDPR()
//                .checkPrivatePolicy()
//                .gotoDibsPage()
//                .confirmOrderWithMasterCard()
//                .verifyThankYouPage();
}




