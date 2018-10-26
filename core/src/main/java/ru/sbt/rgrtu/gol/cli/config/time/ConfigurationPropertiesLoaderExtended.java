package ru.sbt.rgrtu.gol.cli.config.time;

import ru.sbt.rgrtu.gol.cli.config.Configuration;
import ru.sbt.rgrtu.gol.cli.config.ConfigurationPropertiesLoader;

import java.util.Properties;

public class ConfigurationPropertiesLoaderExtended extends ConfigurationPropertiesLoader {

    public ConfigurationPropertiesLoaderExtended(String file) {
        super(file);
    }

    @Override
    protected Configuration toConfiguration(Properties properties) {
        Configuration configuration = new ConfigurationExtended();
        configuration.setSizeX(Integer.parseInt(properties.getProperty("game.board.size.x")));
        configuration.setSizeY(Integer.parseInt(properties.getProperty("game.board.size.y")));
        configuration.setSeed(Long.parseLong(properties.getProperty("game.seed")));
        ((ConfigurationExtended) configuration).setTime(Integer.parseInt(properties.getProperty("game.time")));
        return configuration;
    }
}
