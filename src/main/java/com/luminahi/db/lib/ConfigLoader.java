package com.luminahi.db.lib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    
    private Properties properties;

    public ConfigLoader(String filepath) {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(filepath);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperties(String key) {
        return properties.getProperty(key);
    }
}
