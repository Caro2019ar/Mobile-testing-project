package com.carina.base;

import com.carina.utils.logs.Log;
import io.appium.java_client.android.AndroidDriver;

import java.util.Set;

public class ContextHandler {

    public void changeContext(AndroidDriver driver) {
        Set<String> contexts = driver.getContextHandles();
        for (String context : contexts) {
            Log.info("Actual context: " + context + " -contexts size: " + contexts.size());
            driver.context((String) contexts.toArray()[1]);
        }
        driver.context((String) contexts.toArray()[1]);
    }

}
