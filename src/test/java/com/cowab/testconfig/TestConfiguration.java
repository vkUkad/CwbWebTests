package com.cowab.testconfig;

import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.recorder.VideoRecorder;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.cowab.utils.EnvironmentBuilder;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.Getter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@Getter
@Listeners(UniversalVideoListener.class)
public class TestConfiguration {

    @Attachment(type = "image/png")
    public static byte[] addScreenshot(byte[] dataForScreenshot) {
        return dataForScreenshot;
    }

    @Attachment(type = "text/plain", fileExtension = "log")
    public static String attachText(String attachedText) {
        return attachedText;
    }

    @Attachment(value = "video", type = "video/mp4")
    public byte[] addVideo() {
        try {
            File video = VideoRecorder.getLastRecording();
            await().atMost(5, TimeUnit.SECONDS)
                    .pollDelay(1, TimeUnit.SECONDS)
                    .ignoreExceptions()
                    .until(() -> video != null);
            return Files.readAllBytes(Paths.get(video.getAbsolutePath()));
        } catch (IOException e) {
            return new byte[0];
        }
    }

    @BeforeSuite()
    public void doPrecondition() {
        Configuration.savePageSource = false;
        Configuration.timeout = 10000;
    }

    @BeforeMethod()
    public void driverInit() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterMethod()
    public void tearDown(ITestResult result) {
        EnvironmentBuilder.getAllureEnvironment();
        WebDriverRunner.getWebDriver().close();
        if (result.getStatus() == ITestResult.FAILURE) {
           // addVideo();
        }
    }
}
