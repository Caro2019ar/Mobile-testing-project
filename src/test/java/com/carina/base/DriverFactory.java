package com.carina.base;

import com.carina.log.Log;
import com.carina.util.DesiredCapabilitiesUtil;
import com.carina.util.PropertiesUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static AppiumDriver driver;
    private static final DesiredCapabilitiesUtil desiredCapabilitiesUtil = new DesiredCapabilitiesUtil();

    public static AppiumDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    private static void createDriver() {
        PropertiesUtil prop = new PropertiesUtil("config.properties");
        DesiredCapabilities caps = desiredCapabilitiesUtil.getDesiredCapabilities();
        try {
            driver = new AndroidDriver<>(new URL(prop.readProperty("androiddriver.url")), caps);

        } catch (MalformedURLException e) {
            Log.error("Could not form URL for Android Driver " + e.getMessage());
        }
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
