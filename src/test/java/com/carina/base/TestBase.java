package com.carina.base;

import com.carina.utils.logs.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public static AppiumDriver driver;


    public static void android_setUp() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("automation  Name", "UiAutomator2");
        caps.setCapability("noReset", true);
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/carinademoexample.apk");
        try {
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
            Log.info("Driver setUp OK");
        } catch (MalformedURLException e) {
            Log.error("error");
        }
    }

    @AfterTest
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
