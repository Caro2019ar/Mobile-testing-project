package com.carina.base;

import com.carina.log.Log;
import io.appium.java_client.AppiumDriver;

import java.util.Set;

public class ContextHandler {

    public static void changeContext(AppiumDriver driver, String contextName) {
        Set<String> contexts = driver.getContextHandles();
        for (String context : contexts) {
            Log.info("Context 1: " + context);
            if (context.contains("WEBVIEW") && contextName.contains("WEB")) {
                Log.info("Context 1 - Contains WEBVIEW: " + context);
                driver.context(context);
                break;
            } else if (context.contains("NATIVE") && contextName.contains("NATIVE")) {
                Log.info("Context 2: " + context);
                driver.context(context);
                break;
            }

        }
    }


}
