package com.cowab.utils;

import java.io.File;
import java.util.Properties;

public class Configuration {

    public static final boolean DEBUG_MODE = Boolean.valueOf(System.getProperty("DEBUG_MODE", String.valueOf("true")));

    public static final String propertyPath = "src" + File.separator
            + "main" + File.separator
            + "resources" + File.separator
            + "config.properties";

    public static Properties myProp = new PropertiesReader(propertyPath).getMyProperty();
    public static final String TESTING_URL_SE = myProp.getProperty("TESTING_URL_SE");
    public static final String TESTING_URL_NO = myProp.getProperty("TESTING_URL_NO");
    public static final String DESKTOP_REMOTE_URL = myProp.getProperty("SELENOID_URL");

}