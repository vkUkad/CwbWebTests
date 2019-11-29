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
import org.testng.annotations.AfterTest;
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
                .goToLoginCheckout()
                .registerPrivateUserCheckout(user)
                .addNewDeliveryAddressPrivate("TestFirstName", "TestLastName", "TestApi address 1", "12345", "TestCity")
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
                .goToLoginCheckout()
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
                .goToLoginCheckout()
                //  .loginOnCheckout("testcowabprivate@gmail.com", "q1w2e3r4T%")
                .loginOnCheckout("autotestsepriv@mailinator.com", "Q!w2e3r4t5y6")
                .verifyDeliveryPage();
    }

    @Test(description = "Login on checkout with existing Private user, full workflow")
    public void checkoutExistingPrivateFull() throws AWTException {
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .openProductListingForQuery("40046")
                .addTheFirstProductToTheCart()
                .openCart()
                .goToLoginCheckout()
                .loginOnCheckout("vikentiy.kelevich@mailinator.com", "Q!w2e3r4t5y6")
                .addNewDeliveryAddressPrivate("TestFirstName", "TestLastName", "TestApi address 1", "12345", "TestCity")
                .addPhoneNotification("+46712345671", "TestPhone")
                .addOrderLabel("TEST ORDER IGNORE IT")
                .gotoPaymentPage()
                .gotoFinalizePage()
                .checkPrivatePolicy(driver)
                .gotoDibsPage()
                .confirmOrderWithMasterCard()
                .verifyThankYouPage();
    }

    @Test(description = "Register new user and check 'newsletter subscription' functionality")
    public void checkoutNewsletterSubscriptionFunctionality() throws AWTException {
        User userSE = UserGenerator.generateUserSE();
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .registerCompanyUser(userSE)
                .verifyLoginName(userSE.getUserName())
                .logout();

        new BasePage().openMainPage(TESTING_URL_SE)
                .login(userSE.getEmail(), userSE.getPassword())
                .verifyLoginName(userSE.getUserName())
                .openMyPages()
                .verifyIfExpectedStateAppearsBeforeSubscription()
                .openProductListingForQuery("matta")
                .addTheFirstProductToTheCart()
                .openCart()
                .goToCheckout()
                .addOrderLabel("TEST_PLEASE_IGNORE")
                .gotoPaymentPage()
                .selectInvoicePayment()
                .gotoFinalizePage()
                .checkPrivatePolicy(driver, true)
                .checkNewsletterSubscriptionCheckbox()
                .gotoThankYouPage()
                .goToMyPages()
                .checkIfExpectedStateAppearsAfterSubscription();
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}

