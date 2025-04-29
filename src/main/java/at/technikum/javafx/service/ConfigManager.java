package at.technikum.javafx.service;

import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private final Properties properties;

    public ConfigManager() {
        this.properties = new Properties();

        try {
            this.properties.load(
                    getClass().getClassLoader().getResourceAsStream(
                            "config.properties"
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String get(String key) {
        return this.properties.getProperty(key);
    }
}
