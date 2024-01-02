package org.kafkaconsumer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

enum Environment {
    Development,
    Production
}

public class AppConfig {

    /**
     * Represents the logger instance.
     */
    private final Logger _logger;

    /**
     * Represents the parsed application properties.
     */
    private final Properties properties;

    /**
     * Gets the underlying properties.
     * @return
     */
    public Properties getProperties() {
        return this.properties;
    }

    public AppConfig() {
        this._logger = LoggerFactory.getLogger(this.getClass().getName());
        this._logger.info("Retrieving configuration...");
        String environment = System.getenv("environment");
        this.properties = new Properties();
        try (InputStream is = getClass().getResourceAsStream("application.properties")) {
            this.properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
