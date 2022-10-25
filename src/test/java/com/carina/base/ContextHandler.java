package com.carina.base;

import com.carina.logs.Log;
import io.appium.java_client.AppiumDriver;

import java.util.Set;

public class ContextHandler {

    public static void changeContext(AppiumDriver driver, String contextName) {
        Set<String> contexts = driver.getContextHandles();
        for (String context : contexts) {
            Log.info("Context: " + context);
            driver.context(contextName);
        }
    }

}
