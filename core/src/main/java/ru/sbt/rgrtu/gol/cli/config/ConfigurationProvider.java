package ru.sbt.rgrtu.gol.cli.config;

/** Load simulation settings from any source. */
public interface ConfigurationProvider {

    /** Get simulation settings. */
    Configuration getConfiguration();
}
