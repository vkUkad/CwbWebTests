package com.cowab.search;

import com.codeborne.selenide.WebDriverRunner;
import com.cowab.pages.BasePage;
import com.cowab.testconfig.TestConfiguration;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.cowab.utils.Configuration.TESTING_URL_SE;
import static com.cowab.utils.driver.MyDriverManager.createWebDriver;

@Feature("Search")
@Story("Search")
public class Search extends TestConfiguration {

    @Test(description = "Verify that categories are displayed")
    public void verifyCategory() {
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .searchQuery("Bord")
                .verifyCategoryIsDisplayed();
    }

    @Test(description = "Verify searchAsYourType for query 'Bord'")
    public void verifySearchAsYouTypeMulti() {
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .searchQuery("Bord")
                .verifyNumberOfSearchAsYourType(4);
    }

    @Test(description = "Verify searchAsYourType for articleNumber '5005523'")
    public void verifySearchAsYouTypeSingle() {
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .searchQuery("5005523")
                .verifyNumberOfSearchAsYourType(1);
    }

    @Test(description = "Search query: 'Bord'")
    public void searchBord() {
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .openProductListingForQuery("Bord")
                .verifyNumberOfDisplayedProducts(36);
    }

    @Test(description = "Search item by article number: '5005523'")
    public void searchByArtNumber() {
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .openProductListingForQuery("5005523")
                .verifyNumberOfDisplayedProducts(1);
    }
}
