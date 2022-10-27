package com.carina.base;

import com.carina.logs.Log;
import com.carina.util.DesiredCapabilitiesUtil;
import com.carina.util.PropertiesUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    public static AppiumDriver<MobileElement> driver;
    private final DesiredCapabilitiesUtil desiredCapabilitiesUtil = new DesiredCapabilitiesUtil();
    PropertiesUtil prop = new PropertiesUtil("config.properties");

    @BeforeTest
    public void android_setUp() {
        DesiredCapabilities caps = desiredCapabilitiesUtil.getDesiredCapabilities();
        try {
            driver = new AndroidDriver<>(new URL(prop.readProperty("androiddriver.url")), caps);
            DriverThread.setTLDriver(driver);
        } catch (MalformedURLException e) {
            Log.error("Could not form URL for Android Driver " + e.getMessage());
        }
    }

    @AfterTest
    public synchronized void teardown() {
        if (driver != null)
            driver.quit();
    }

}
