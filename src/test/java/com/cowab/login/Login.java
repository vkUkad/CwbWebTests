package com.cowab.login;

import com.codeborne.selenide.Configuration;
import com.cowab.data_generator.UserGenerator;
import com.cowab.objects.User;
import com.cowab.pages.BasePage;
import com.cowab.testconfig.TestConfiguration;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.cowab.utils.Configuration.TESTING_URL_SE;

@Feature("Login/Registration")
@Story("Login/Registration")
public class Login extends TestConfiguration {

    @BeforeTest
    public void doPreconditions() {
        Configuration.remote = "http://192.168.0.217:8080/wd/hub/";
        Configuration.driverManagerEnabled = false;
    }

    @Test(description = "Test login with a Company user")
    public void loginCompany() {
        //     WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .login("autotestsebus@mailinator.com", "Q!w2e3r4t5y6")
                .verifyLoginName("Autotestname")
                .logout()
                .checkIfUserIsLoggedOut("Apitestname");

    }

    @Test(description = "Test login with a Private user")
    public void loginPrivate() {
        //    WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .login("autotestsepriv@mailinator.com", "Q!w2e3r4t5y6")
                .verifyLoginName("Testfirstname")
                .logout()
                .checkIfUserIsLoggedOut("Apitestname");
    }

    @Test(description = "Register a Company user")
    public void registerCompany() {
        User userSE = UserGenerator.generateUserSE();
        //    WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .registerCompanyUser(userSE)
                .verifyLoginName(userSE.getUserName())
                .logout()
                .checkIfUserIsLoggedOut(userSE.getUserName());
    }

    @Test(description = "Register a Private user")
    public void registerPrivate() {
        User userSE = UserGenerator.generateUserSE();
        //     WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .selectCompanyVisitorType()
                .registerPrivateUser(userSE)
                .verifyLoginName(userSE.getUserName())
                .logout()
                .checkIfUserIsLoggedOut(userSE.getUserName());
    }
}
