package com.cowab.temptests;

import com.codeborne.selenide.WebDriverRunner;
import com.cowab.testconfig.TestConfiguration;
import com.cowab.utils.driver.MyDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.cowab.utils.Configuration.TESTING_URL_SE;


public class TestTemplate extends TestConfiguration {

//    @BeforeClass(description = "Create test users/data")
//    public void doPreconditions() {
//        WebDriverRunner.setWebDriver(MyDriverManager.createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
//
//// Before class methods
//        close();
//    }


    @Test(description = "Template test")
    public void testName() {
//        WebDriverRunner.setWebDriver(MyDriverManager.createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        System.out.println(TESTING_URL_SE);

        open(TESTING_URL_SE);

        sleep(1000);
        System.out.println("Test OK!");

    }


//    @AfterClass(description = "Do cleanup")
//    public void cleanUp() {
//        WebDriverRunner.setWebDriver(MyDriverManager.createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
//
//// clean up methods
//        close();
//
//
//    }

}
