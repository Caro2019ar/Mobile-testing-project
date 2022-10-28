package com.carina.util;

import com.carina.log.Log;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    private final Properties properties;

    public PropertiesUtil(String propFile){
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(propFile));
        } catch (IOException e) {
            Log.error(e.getMessage()+ " IOException when loading properties of config.properties");
        }
    }

    public String readProperty(String propertyKey){
        Log.info(propertyKey + " : "+properties.getProperty(propertyKey));
        return properties.getProperty(propertyKey);
    }
}
