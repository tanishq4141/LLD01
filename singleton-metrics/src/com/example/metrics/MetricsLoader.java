package com.example.metrics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Loads default metric keys from a properties file.
 *
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - Uses 'new MetricsRegistry()' instead of the singleton.
 *
 * TODO (student):
 *  - Use MetricsRegistry.getInstance() and remove all direct instantiation.
 */
public class MetricsLoader {

    public MetricsRegistry loadFromFile(String propertiesPath) throws IOException {
        Properties metricsProps = new Properties();
        try (FileInputStream fileStream = new FileInputStream(propertiesPath)) {
            metricsProps.load(fileStream);
        }

        MetricsRegistry registry = MetricsRegistry.getInstance();

        for (String counterName : metricsProps.stringPropertyNames()) {
            String rawValue = metricsProps.getProperty(counterName, "0").trim();
            long initialCount;
            try {
                initialCount = Long.parseLong(rawValue);
            } catch (NumberFormatException parseError) {
                initialCount = 0L;
            }
            registry.setCount(counterName, initialCount);
        }
        return registry;
    }
}
