package com.cowab.checkout;

import com.codeborne.selenide.WebDriverRunner;
import com.cowab.data_generator.UserGenerator;
import com.cowab.objects.User;
import com.cowab.pages.BasePage;
import com.cowab.testconfig.TestConfiguration;
import com.cowab.utils.driver.MyDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

import static com.cowab.utils.Configuration.TESTING_URL_SE;
import static com.cowab.utils.driver.MyDriverManager.createWebDriver;

@Feature("Checkout")
@Story("Checkout flow")
public class Checkout extends TestConfiguration {
    WebDriver driver = MyDriverManager.createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName());

    @Test(description = "Checkout with new Company user")
    public void checkoutNewCompany() throws AWTException {
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
                .checkPrivatePolicy(driver)
                .gotoThankYouPage()
                .verifyThankYouPage();
    }

    @Test(description = "Checkout with new Private user")
    public void checkoutNewPrivate() throws AWTException {
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
                .checkPrivatePolicy(driver)
                .gotoDibsPage()
                .confirmOrderWithMasterCard()
                .verifyThankYouPage()
        ;
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
                //  .loginOnCheckout("testcowabprivate@gmail.com", "q1w2e3r4T%")
                .loginOnCheckout("vikentiy.kelevich@gmail.com", "Q!w2e3r4t5y6")
                .verifyDeliveryPage();
    }

    @Test(description = "Login on checkout with existing Private user")
    public void checkoutExistingPrivateFull() throws AWTException {
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .openProductListingForQuery("40046")
                .addTheFirstProductToTheCart()
                .openCart()
                .goToCheckout()
                .loginOnCheckout("vikentiy.kelevich@mailinator.com", "Q!w2e3r4t5y6")
                .addNewDeliveryAddressPrivate("TestFirstName", "TestLastName", "Test address 1", "12345", "TestCity")
                .addPhoneNotification("+46712345671", "TestPhone")
                .addOrderLabel("TEST ORDER IGNORE IT")
                .gotoPaymentPage()
                .gotoFinalizePage()
                .checkPrivatePolicy(driver)
                .gotoDibsPage()
                .confirmOrderWithMasterCard()
                .verifyThankYouPage();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}

