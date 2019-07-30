package com.cowab.utils;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    @Getter
    private Properties myProperty = new Properties();

    public PropertiesReader(String path) {
        getProperties(path);
    }

    public void getProperties(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            myProperty.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}