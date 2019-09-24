package com.cowab.utils.driver;

import com.codeborne.selenide.WebDriverRunner;
import com.cowab.utils.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;


public class MyDriverManager {


    private static boolean isDriverInit = false;
    private static String OS = System.getProperty("os.name").toLowerCase();
    private DesiredCapabilities capabilities = new DesiredCapabilities();

    public static void init() {
        if (!isDriverInit) {
            ChromeDriverManager.chromedriver().setup();
            isDriverInit = true;
        }
    }

    public static WebDriver createWebDriver(String testName) {
        if (Configuration.DEBUG_MODE) {
//            System.setProperty("webdriver.chrome.driver", getCustomDriverPath());
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        } else {
            return createRemoteDriver(testName);
        }
    }

    /***
     *Create Chrome local driver for debug
     *
     *    @return WebDriver
     *
     ***/
    public static WebDriver createLocalDriver() {
        init();
        //TODO delete when Chrome 75 released
        System.setProperty("webdriver.chrome.driver", getCustomDriverPath());
        com.codeborne.selenide.Configuration.browser = "chrome";
        return WebDriverRunner.getWebDriver();
    }

    public static String getCustomDriverPath() {

        if (OS.contains("win")) {
            System.out.println("WIN");
            return "drivers" + File.separator + "chromewin" + File.separator + "chromedriver.exe";
        } else if (OS.contains("mac")) {
            System.out.println("MAC");
            return "drivers" + File.separator + "chromemac" + File.separator + "chromedriver";
        } else if (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0) {
            System.out.println("NIX");
            return "drivers" + File.separator + "chromenix" + File.separator + "chromedriver";
        }

        return null;
    }

    private static WebDriver createRemoteDriver(String testName) {
        return new MyDriverManager()
                .createCustomChromeRemoteDriver(Configuration.DESKTOP_REMOTE_URL, testName);
    }

    /***
     *Create Chrome remote driver to run on Selenoid with VNC
     *
     *    @return RemoteWebDriver
     *
     ***/
    private WebDriver createCustomChromeRemoteDriver(String remoteURL, String testName) {
//        init();
        com.codeborne.selenide.Configuration.browser = "chrome";
        capabilities.setCapability("enableVNC", true);
        capabilities.setBrowserName("chrome");
        capabilities.setCapability("name", testName);
        capabilities.setCapability("screenResolution", "1440x900x24");
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create(remoteURL).toURL(), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}




