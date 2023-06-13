package utils;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {
    private final static String defaultConfigName = "config.properties";

    private static Properties properties = null;
    private static PropertyReader instance;
    private static String propsFileName = null;

    private PropertyReader() {
    }

    public static PropertyReader getInstance() {
        if (instance == null) {
            instance = new PropertyReader();
        }
        return instance;
    }

    public static String getPropertyValue(String name, String propertiesFileName) {
        if (System.getProperty(name) != null) {
            return System.getProperty(name);
        }
        return getInstance().getValueFromConfigFile(name, propertiesFileName);
    }

    public static String getPropertyValue(String name) {
        return getPropertyValue(name, defaultConfigName);
    }

    private String getValueFromConfigFile(String key, String propertiesFileName) {
        if (properties == null || !propsFileName.equals(propertiesFileName)) {
            properties = loadConfigFile(propertiesFileName);
            propsFileName = propertiesFileName;
        }

        Object objFromFile = properties.getProperty(key);
        if (objFromFile != null) {
            return Objects.toString(objFromFile);
        } else {
            return null;
        }
    }

    private Properties loadConfigFile(String propertiesFileName) {
        try {
            Properties prop = new Properties();
            prop.load(getClass().getClassLoader().getResourceAsStream(propertiesFileName));
            return prop;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
