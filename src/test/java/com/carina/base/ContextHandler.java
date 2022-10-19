package com.carina.base;

import io.appium.java_client.android.AndroidDriver;

import java.util.Set;

public class ContextHandler {

    public void changeContext(AndroidDriver driver) {
        Set<String> contexts = driver.getContextHandles();
        for (String context : contexts) {
            System.out.println("Contexto atual: " + context + " -contexts.size() " + contexts.size());
            driver.context((String) contexts.toArray()[1]);
        }
        driver.context((String) contexts.toArray()[1]);
    }

}
