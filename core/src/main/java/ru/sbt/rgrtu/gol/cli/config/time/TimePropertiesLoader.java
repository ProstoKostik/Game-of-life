package ru.sbt.rgrtu.gol.cli.config.time;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TimePropertiesLoader implements TimeProvider {

    /**
     * Properties file location.
     */
    private final String file;

    /**
     * Create provider with given file location.
     *
     * @param file location of a file in classpath
     */
    public TimePropertiesLoader(String file) {
        this.file = file;
    }

    /**
     * Load settings from a file.
     *
     * @return filled ConfigurationExtended object
     * @throws RuntimeException when unable to locate or parse a required file
     */
    public Time getTime() {
        Properties properties = loadProperties(file);
        Time time = toTime(properties);
        return time;
    }

    private Properties loadProperties(String file) {
        try {
            Properties properties = new Properties();
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
            properties.load(in);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties", e);
        }
    }

    protected Time toTime(Properties properties) {
        Time configuration = new Time();
        configuration.setSleep(Integer.parseInt(properties.getProperty("game.time")));
        return configuration;
    }
}
