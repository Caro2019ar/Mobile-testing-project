package com.carina.base;

import com.carina.util.PropertiesUtil;
import com.carina.utils.logs.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public static AppiumDriver driver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
    PropertiesUtil prop = new PropertiesUtil("config.properties");

    @BeforeSuite
    public void android_setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", prop.readProperty("capabilities.platformName"));
        caps.setCapability("platformVersion", prop.readProperty("capabilities.platformVersion"));
        caps.setCapability("automationName", prop.readProperty("capabilities.automationName"));
        caps.setCapability("noReset", prop.readProperty("capabilities.noReset"));
        caps.setCapability("autoGrantPermissions", prop.readProperty("capabilities.autoGrantPermissions"));
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/carinademoexample.apk");
        //caps.setCapability("app", prop.readProperty("capabilities.appAWS"));
        try {
            driver = new AndroidDriver<>(new URL(prop.readProperty("androiddriver.url")), caps);
            Log.info("Driver setUp OK");
        } catch (MalformedURLException e) {
            Log.error("Error to setup driver: " + e.getMessage());
        }
    }
    public static synchronized WebDriver getWebDriver() {
        tdriver.set(driver);
        return tdriver.get();
    }
    @AfterTest
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
