package com.carina.base;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;

public class DriverFactory {
   /* public static ThreadLocal<DriverThread> tdriver;

    @BeforeSuite
    public static void instatiateDriver() {
        tdriver = new ThreadLocal<DriverThread>() {
            @Override
            protected DriverThread initialValue() {
                DriverThread driverThread = new DriverThread();
                return driverThread;
            }
        };
    }

    public static AppiumDriver getDriver() throws MalformedURLException {
          return tdriver.get().getDriver();

    }

    @AfterMethod
    public static void quitDriver() {
        tdriver.get().quitDriver();
    }*/
}
