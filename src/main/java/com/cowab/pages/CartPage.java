package com.cowab.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.cowab.elements.Cart;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertEquals;

public class CartPage extends BasePage {

    Cart cart = new Cart();

    @Step("Verify that in the cart is present '{x}' products")
    public CartPage verifyNumberOfProductsItCart(int x) {
        cart.getListItemsInCart().shouldHaveSize(x);
        return this;
    }

    @Step("Increase quantity of the product: '{name}'  to 1")
    public CartPage increaseProductQuantityByName(String name) {
        SelenideElement currentElement = getItemByName(name);
        int currentValue = Integer.parseInt(currentElement.$(cart.getLocatorQuantity()).getValue());
        currentElement.$(cart.getLocatorAdd()).parent().click();
        waitPageLoading();
        currentElement.$(cart.getLocatorQuantity()).shouldHave(Condition.value(String.valueOf(currentValue + 1)));
        waitPageLoading();
        verifyPriceItemChanging(currentElement);
        return this;
    }

    @Step("Increase quantity of the first product in a cart to 1")
    public CartPage increaseProductQuantityFirst() {
        SelenideElement currentElement = cart.getListItemsInCart().first();
        int currentValue = Integer.parseInt(currentElement.$(cart.getLocatorQuantity()).getValue());
        currentElement.$(cart.getLocatorAdd()).parent().click();
        waitPageLoading();
        currentElement.$(cart.getLocatorQuantity()).shouldHave(Condition.value(String.valueOf(currentValue + 1)));
        waitPageLoading();
        verifyPriceItemChanging(currentElement);
        return this;
    }

    @Step("Decrease quantity of the first product in a cart to 1")
    public CartPage decreaseProductQuantityFirst() {
        SelenideElement currentElement = cart.getListItemsInCart().first();
        int currentValue = Integer.parseInt(currentElement.$(cart.getLocatorQuantity()).getValue());
        currentElement.$(cart.getLocatorSubtract()).parent().click();
        waitPageLoading();
        currentElement.$(cart.getLocatorQuantity()).shouldHave(Condition.value(String.valueOf(currentValue - 1)));
        waitPageLoading();
        verifyPriceItemChanging(currentElement);
        return this;
    }

    @Step("Increase quantity of the product: '{name}'  to 1")
    public CartPage decreaseProductQuantityByName(String name) {
        SelenideElement currentElement = getItemByName(name);
        int currentValue = Integer.parseInt(currentElement.$(cart.getLocatorQuantity()).getValue());
        currentElement.$(cart.getLocatorSubtract()).parent().click();
        waitPageLoading();
        currentElement.$(cart.getLocatorQuantity()).shouldHave(Condition.value(String.valueOf(currentValue + 1)));
        waitPageLoading();
        verifyPriceItemChanging(currentElement);
        return this;
    }

    @Step("Remove the first product in a cart")
    public CartPage removeProductFirst() {
        SelenideElement currentElement = cart.getListItemsInCart().first();
        currentElement.$(cart.getLocatorDelete()).click();
        waitPageLoading();
        return this;
    }

    @Step("Remove the product: '{name}'")
    public CartPage removeProductByName(String name) {
        SelenideElement currentElement = getItemByName(name);
        currentElement.$(cart.getLocatorDelete()).parent().click();
        waitPageLoading();
        return this;
    }

    @Step("Press 'Go to checkout button'")
    public CheckoutLoginPage goToCheckout() {
        cart.getBtnGoToCheckout().click();
        waitPageLoading();
        deleteImbox();
        return new CheckoutLoginPage();
    }

    @Step("Verify 'Cart Price block'")
    public CartPage verifyCartPriceBlock() {
        int calculatedTotalPrice = calculateTotalPrice();
        int calculatedDelivery = calculateDeliveryCost();
        int calculatedMoms = (int) Math.round((calculatedTotalPrice + calculatedDelivery) * 0.25);
        int calculatedTotalWithoutMoms =  calculatedTotalPrice + calculatedDelivery;
        int calculatedTotalWithMoms = calculatedTotalPrice + calculatedDelivery + calculatedMoms;
        assertEquals(getSubTotalCart(), calculateTotalPrice(), "Wrong total price");
        assertEquals(getMoms(), calculatedMoms, "Wrong moms");
        assertEquals(getDeliveryCost(), calculatedDelivery, "Wrong delivery");
        assertEquals(getTotalCartWithoutMoms(), calculatedTotalWithoutMoms, "Wrong total without moms");
        assertEquals(getTotalCartPriceWithMoms(), calculatedTotalWithMoms, "Wrong total with moms");
        return this;
    }

    @Step("Get 'Delivery cost'")
    private int getSubTotalCart() {
        return parsePrice(cart.getLabelSubtotal().getText());
    }

    @Step("Calculate delivery according to rules")
    private int calculateDeliveryCost() {

        int totalPrice = calculateTotalPrice();
        if (0 < totalPrice && totalPrice < 1500) {
            return 275;
        } else if(1500 < totalPrice && totalPrice < 6000){
            return (int) Math.round(totalPrice * 0.18);
        } else if(6000 < totalPrice && totalPrice < 12000){
            return (int) Math.round(totalPrice * 0.12);
        } else if(totalPrice > 12000){
            return 0;
        }

        return -1;
    }

    @Step("Get 'Total cart price without VAT'")
    private int getTotalCartWithoutMoms() {
        return parsePrice(cart.getLabelTotalWithoutMoms().getText());
    }

    @Step("Get 'Delivery cost'")
    private int getDeliveryCost() {
        return parsePrice(cart.getLabelDelivery().getText());
    }

    @Step("Get 'Moms'")
    private int getMoms() {
        return parsePrice(cart.getLabelMoms().getText());
    }

    @Step("Get 'Moms'")
    private int getTotalCartPriceWithMoms() {
        return parsePrice(cart.getLabelTotalPrice().getText());
    }

    @Step("Calculate total card articles price")
    private int calculateTotalPrice() {
        int totalPrice = 0;
        for (SelenideElement element : $$(cart.getLocatorTotalPrice())) {
            totalPrice += parsePrice(element.getText());
        }
        return totalPrice;
    }

    private SelenideElement getItemByName(String name) throws ElementNotFound {
        for (SelenideElement currentItem : cart.getListItemsInCart()) {
            if (currentItem.has(Condition.matchesText(name))) {
                return currentItem;
            }
        }
        throw new NoSuchElementException("Element is not found in a cart: " + name);
    }

    private void verifyPriceItemChanging(SelenideElement currentElement) {
        int price = parsePrice(currentElement.$(cart.getLocatorPrice()).getText());
        int quantity = Integer.parseInt(currentElement.$(cart.getLocatorQuantity()).getValue());
        int totalPrice = parsePrice(currentElement.$(cart.getLocatorTotalPrice()).getText());

        assertEquals(totalPrice, price * quantity);
    }
}
