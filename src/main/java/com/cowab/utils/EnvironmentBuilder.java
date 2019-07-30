package com.cowab.utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EnvironmentBuilder {

    public static boolean isEnvironmentSet = false;

    public static void getAllureEnvironment() {
        if (!isEnvironmentSet) {

            Capabilities cap = ((RemoteWebDriver) WebDriverRunner.getWebDriver()).getCapabilities();

            String browser = cap.getBrowserName().toLowerCase();

            String version = cap.getVersion();
            String os = cap.getPlatform().toString();
            StringBuilder sb = new StringBuilder();

            sb.append("Browser=");
            sb.append(browser);
            sb.append("\n");
            sb.append("Browser.Version=");
            sb.append(version);
            sb.append("\n");
            sb.append("Stand=");
            sb.append(os);
            String result = sb.toString();

//            try (FileWriter file = new FileWriter("src/main/resources/environment.properties")) {
            try (FileWriter file = new FileWriter("target" + File.separator
                    + "allure-results" + File.separator
                    + "environment.properties")) {

                file.write(result);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            isEnvironmentSet = true;
        }
    }

}
