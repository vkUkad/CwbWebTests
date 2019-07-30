package com.cowab.login;

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

@Feature("Login/Registration")
@Story("Login/Registration")
public class Login extends TestConfiguration {

    @Test(description = "Test login with a Company user")
    public void loginCompany() {
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .login("vzotke@gmail.com", "q1w2e3r4T%")
                .verifyLoginName("Test")
                .logout();
    }

    @Test(description = "Test login with a Private user")
    public void loginPrivate() {
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .login("vzotketest@gmail.com", "q1w2e3r4T%")
                .verifyLoginName("TestFirstName")
                .logout();
    }

    @Test(description = "Register a Company user")
    public void registerCompany() {
        User userSE = UserGenerator.generateUserSE();
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .registerCompanyUser(userSE)
                .verifyLoginName(userSE.getUserName())
                .logout();
    }

    @Test(description = "Register a Private user")
    public void registerPrivate() {
        User userSE = UserGenerator.generateUserSE();
        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .registerPrivateUser(userSE)
                .verifyLoginName(userSE.getUserName())
                .logout();
    }
}
