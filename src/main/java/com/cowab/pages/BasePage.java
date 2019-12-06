package com.cowab.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Text;
import com.cowab.elements.Header;
import com.cowab.elements.LoginPopup;
import com.cowab.elements.MyPages;
import com.cowab.elements.ProductListing;
import com.cowab.objects.User;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BasePage {

    Header header = new Header();
    LoginPopup loginPopup = new LoginPopup();
    ProductListing productListing = new ProductListing();

    @Step("Open main page")
    public MainPage openMainPage(String URL) {
        Selenide.open(URL);
        deleteImbox();
        return new MainPage();
    }

    @Step("Open main page")
    public BasePage selectCompanyVisitorType() {
        header.getBtnCompany().click();
        return this;
    }

    @Step("Login with a username: {userName}")
    public BasePage login(String userName, String password) {
        openLoginPopup();
        loginPopup.getFieldLogin().sendKeys(userName);
        loginPopup.getFieldPassword().sendKeys(password);
        loginPopup.getBtnLogin().click();
        waitPageLoading();
        return this;
    }

    @Step("Verify that username '{userName}' is displayed after login")
    public BasePage verifyLoginName(String userName) {
        header.getBtnLogin().shouldHave(Condition.text(userName));
        waitPageLoading();
        return this;
    }

    @Step("Logout")
    public BasePage logout() {
        header.getBtnLogin().click();
        header.getBtnLogout().waitUntil(Condition.visible, 10000).click();
        waitPageLoading();
        return this;
    }

    @Step("Register new Company user with the mail: {user.email}")
    public BasePage registerCompanyUser(User user) {
        openLoginPopup();
        loginPopup.getBtnRegister().waitUntil(Condition.appears, 5000).click();
        loginPopup.getRadioCompany().click();
        loginPopup.getFieldEmail().sendKeys(user.getEmail());
        loginPopup.getFieldEmailRepeat().sendKeys(user.getEmail());
        loginPopup.getFieldRegisterPassword().sendKeys(user.getPassword());
        loginPopup.getFieldRegisterPasswordRepeat().sendKeys(user.getPassword());
        loginPopup.getBtnContinueRegistration().click();
        waitPageLoading();
        loginPopup.getFieldOrganisationNumber().sendKeys(user.getOrganisationNumber());
        loginPopup.getFieldCompanyName().sendKeys(user.getCompanyName());
        loginPopup.getFieldUserName().sendKeys(user.getUserName());
        loginPopup.getFieldUserLastName().sendKeys(user.getUserLastName());
        loginPopup.getFieldUserMobile().sendKeys(user.getUserMobile());
        loginPopup.getFieldAddress().sendKeys(user.getAddress());
        loginPopup.getFieldPostCode().sendKeys(user.getPostCode());
        loginPopup.getFieldCity().sendKeys(user.getCity());
        //loginPopup.getFieldPhone().sendKeys(user.getPhone());
        loginPopup.getCheckboxSecurityPolicy().click();
        loginPopup.getBtnContinueRegistration().click();
        waitPageLoading();
        return this;
    }

    @Step("Register new private user with the mail: {user.email}")
    public BasePage registerPrivateUser(User user) {
        openLoginPopup();
        loginPopup.getBtnRegister().waitUntil(Condition.appears, 5000).click();
        loginPopup.getRadioPrivate().click();
        loginPopup.getFieldEmail().sendKeys(user.getEmail());
        loginPopup.getFieldEmailRepeat().sendKeys(user.getEmail());
        loginPopup.getFieldRegisterPassword().sendKeys(user.getPassword());
        loginPopup.getFieldRegisterPasswordRepeat().sendKeys(user.getPassword());
        loginPopup.getBtnContinueRegistration().click();
        waitPageLoading();
        loginPopup.getFieldUserName().sendKeys(user.getUserName());
        loginPopup.getFieldUserLastName().sendKeys(user.getUserLastName());
        loginPopup.getFieldUserMobile().sendKeys(user.getUserMobile());
        loginPopup.getFieldAddress().sendKeys(user.getAddress());
        loginPopup.getFieldPostCode().sendKeys(user.getPostCode());
        loginPopup.getFieldCity().sendKeys(user.getCity());
        //loginPopup.getFieldPhone().sendKeys(user.getPhone());
        loginPopup.getCheckboxSecurityPolicy().click();
        loginPopup.getBtnContinueRegistration().click();
        waitPageLoading();
        return this;
    }

    @Step("Open search bar")
    public BasePage openSearchBar() {
        header.getSearchIcon().click();
        return this;
    }

    @Step("Search query '{query}'")
    public BasePage searchQuery(String query) {
        openSearchBar();
        header.getFieldSearch().click();
        header.getFieldSearch().sendKeys(query);
        header.getIconLoading().waitUntil(Condition.disappears, 5000);
        return this;
    }

    @Step("Open product listing page for the search query: '{query}'")
    public ProductListingPage openProductListingForQuery(String query) {
        searchQuery(query);
        header.getFieldSearch().pressEnter();
        return new ProductListingPage();
    }

    @Step("Verify that searchAsYourType contains '{x}' products")
    public BasePage verifyNumberOfSearchAsYourType(int x) {
        header.getListFoundProducts().shouldHaveSize(x);
        return this;
    }

    @Step("Verify that category is displayed")
    public BasePage verifyCategoryIsDisplayed() {
        header.getListCategory().shouldBe(CollectionCondition.sizeGreaterThanOrEqual(1));
        return this;
    }

    @Step("Open cart")
    public CartPage openCart() {
        header.getBtnCart().click();
        deleteImbox();
        return new CartPage();
    }

    @Step("Verify cart icon display number")
    public BasePage verifyNumberOnCartIcon(String text) {
        header.getLabelCartCount().shouldHave(Text.text(text));
        return this;
    }

    @Step("Wait page loading")
    public BasePage waitPageLoading() {
        sleep(1000);
        header.getLoader().waitUntil(Condition.disappears, 100000);
        sleep(1000);
        return this;
    }

    @Step("Parse price")
    public int parsePrice(String price) {
        return Integer.parseInt(price.replaceAll(" ", "")
                .replaceAll(":-", "")
                .replaceAll(",-", ""));
    }

    @Step("Scroll to top of page")
    public BasePage scrollToTop() {
        ((JavascriptExecutor) getWebDriver())
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }

    @Step("Open login popup")
    private BasePage openLoginPopup() {
        header.getBtnLogin().click();
        loginPopup.getModalSignIn().waitUntil(Condition.attribute("style", "display: block;"), 10000);
        sleep(1000); //wait popup animation
        return this;
    }

    @Step("Delete imbox frame")
    public BasePage deleteImbox() {
        if ($("#imbox-container").exists()) {
            executeJavaScript("document.getElementById('imbox-container').remove();", "");
        }
        return this;
    }

    @Step("Open my pages")
    public MyPagesPage openMyPages() {
        header.getBtnLoggedInUser().click();
        header.getBtnMyPages().click();
        return new MyPagesPage();
    }

    @Step("Open first product from the page")
    public ProductPage openFirstProductFromThePage() {
        waitPageLoading();
        productListing.getListProducts().first().hover();
        productListing.getListProducts().first().click();
        return new ProductPage();
    }

    @Step("Check if user is logged out")
    public void checkIfUserIsLoggedOut(String userName) {
        header.getBtnLogin().shouldNotHave(Condition.text(userName));
        waitPageLoading();
    }

    @Step("Click on the element: \"{name}\" by mouse over")
    public void clickOnTheElementByMouseOver(SelenideElement element) throws AWTException {
        String name = element.getTagName();
        int x = element.getLocation().getX() + 15;
        int y = element.getLocation().getY() + 92;
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(KeyEvent.BUTTON1_MASK);
        bot.mouseRelease(KeyEvent.BUTTON1_MASK);
    }
}
