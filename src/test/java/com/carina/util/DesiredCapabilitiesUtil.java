package com.carina.util;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DesiredCapabilitiesUtil {
    PropertiesUtil prop = new PropertiesUtil("config.properties");
    public DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", prop.readProperty("capabilities.platformName"));
        caps.setCapability("platformVersion", prop.readProperty("capabilities.platformVersion"));
        caps.setCapability("automationName", prop.readProperty("capabilities.automationName"));
        caps.setCapability("noReset", prop.readProperty("capabilities.noReset"));
        caps.setCapability("autoGrantPermissions", prop.readProperty("capabilities.autoGrantPermissions"));
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/carinademoexample.apk");
        return caps;
    }
}
