package com.cowab.temptests;

import com.automation.remarks.video.annotations.Video;
import com.codeborne.selenide.WebDriverRunner;
import com.cowab.pages.BasePage;
import com.cowab.testconfig.TestConfiguration;
import org.testng.annotations.Test;

import static com.cowab.utils.Configuration.TESTING_URL_SE;
import static com.cowab.utils.driver.MyDriverManager.createWebDriver;

public class TempTest extends TestConfiguration
        /*extends TestConfiguration */ {

    //    @BeforeMethod
//    public void before(){
//        Selenide.open("/sv/se");
//    }


    @Test(description = "Check video")
    @Video
    public void tempTest() {

        WebDriverRunner.setWebDriver(createWebDriver(Thread.currentThread().getStackTrace()[1].getMethodName()));
        new BasePage().openMainPage(TESTING_URL_SE)
                .verifyNumberOnCartIcon("2");
    }
}

