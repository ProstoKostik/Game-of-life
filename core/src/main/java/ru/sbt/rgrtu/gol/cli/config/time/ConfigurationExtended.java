package ru.sbt.rgrtu.gol.cli.config.time;

import ru.sbt.rgrtu.gol.cli.config.Configuration;

public class ConfigurationExtended extends Configuration {

    private int time;

    public ConfigurationExtended() {

    }

    public ConfigurationExtended(int sizeX, int sizeY, long seed, int time) {
        super(sizeX, sizeY, seed);
        this.time = time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}
