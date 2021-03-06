package com.cowab.wishlist;

import com.codeborne.selenide.Configuration;
import com.cowab.data_generator.UserGenerator;
import com.cowab.objects.User;
import com.cowab.pages.BasePage;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.cowab.utils.Configuration.TESTING_URL_SE;

public class Wishlist {
    @BeforeTest
    public void doPreconditions() {
        Configuration.remote = "http://192.168.0.217:8080/wd/hub/";
        Configuration.driverManagerEnabled = false;
    }

    @Test(description = "Share recently created wishlist for new business user")
    public void shareRecentlyCreatedWishlistForNewBusinessUser() {
        User userSE = UserGenerator.generateUserSE();
        //    WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .registerCompanyUser(userSE)
                .verifyLoginName(userSE.getUserName())
                .logout();

        new BasePage().openMainPage(TESTING_URL_SE)
                .login(userSE.getEmail(), userSE.getPassword())
                .verifyLoginName(userSE.getUserName())
                .openProductListingForQuery("matta")
                .openFirstProductFromThePage()
                .deleteImboxFromProductPage()
                .clickAddToWishlistButton()
                .filloutNewWishlistNameField(userSE)
                .clickSaveButton()
                .openMyPages()
                .switchTabToShoppingLists()
                .clickOnShareButton()
                .typeRecieverEmail(userSE)
        ;
    }
}
