package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String readPropertyValue(String filePath, String key) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
        }

        return properties.getProperty(key);
    }
}
