package utils;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

private Properties properties;

public ConfigReader() {

    properties = new Properties();

    try {

        InputStream input =
                ConfigReader.class
                        .getClassLoader()
                        .getResourceAsStream("config.properties");

        if (input == null) {
            throw new RuntimeException("config.properties file not found in classpath");
        }

        properties.load(input);

    } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException("Failed to load config.properties file");
    }
}

public String getProperty(String key) {
    return properties.getProperty(key);
}

public int getIntProperty(String key) {
    return Integer.parseInt(properties.getProperty(key));
}

}
