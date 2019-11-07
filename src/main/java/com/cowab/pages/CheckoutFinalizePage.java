package com.cowab.pages;

import com.cowab.elements.CheckoutFinalize;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutFinalizePage extends CheckoutBasePage {

    CheckoutFinalize checkoutFinalize = new CheckoutFinalize();


    @Step("Check GDPR checkbox'")
    public CheckoutFinalizePage checkGDPR(WebDriver driver) {
        return this;
    }

    @Step("Check Private Policy checkbox'")
    public CheckoutFinalizePage checkPrivatePolicy(WebDriver driver) throws AWTException {
        Robot bot = new Robot();
        bot.mouseMove(1320, 800);
        bot.mousePress(KeyEvent.BUTTON1_MASK);
        bot.mouseRelease(KeyEvent.BUTTON1_MASK);
        return this;
    }

    @Step("Check Private Policy checkbox'")
    public CheckoutFinalizePage checkPrivatePolicy(WebDriver driver, Boolean existingNewsletterCheckbox) throws AWTException {
        Robot bot = new Robot();
        bot.mouseMove(1320, 775);
        bot.mousePress(KeyEvent.BUTTON1_MASK);
        bot.mouseRelease(KeyEvent.BUTTON1_MASK);
        return this;
    }

    @Step("Check Newsletter subscription checkbox")
    public CheckoutFinalizePage checkNewsletterSubscriptionCheckbox() throws AWTException {
        Robot bot = new Robot();
        bot.mouseMove(1320, 825);
        bot.mousePress(KeyEvent.BUTTON1_MASK);
        bot.mouseRelease(KeyEvent.BUTTON1_MASK);
        return this;
    }

    @Step("Press continue button to go to Thank You page")
    public CheckoutThankYouPage gotoThankYouPage() {
        checkoutFinalize.getBtnSubmit().click();
        waitPageLoading();
        return new CheckoutThankYouPage();
    }

    @Step("Press continue button to go to Thank You page")
    public DibsPaymentPage gotoDibsPage() {
        checkoutFinalize.getBtnSubmit().click();
        waitPageLoading();
        return new DibsPaymentPage();
    }

}
