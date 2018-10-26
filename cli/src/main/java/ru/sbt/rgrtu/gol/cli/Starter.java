package ru.sbt.rgrtu.gol.cli;

import ru.sbt.rgrtu.gol.cli.config.Configuration;
import ru.sbt.rgrtu.gol.cli.config.ConfigurationPropertiesLoader;
import ru.sbt.rgrtu.gol.cli.config.ConfigurationProvider;
import ru.sbt.rgrtu.gol.cli.config.time.TimePropertiesLoader;
import ru.sbt.rgrtu.gol.cli.config.time.TimeProvider;
import ru.sbt.rgrtu.gol.cli.game.Gol;
import ru.sbt.rgrtu.gol.cli.presentation.Presentation;
import ru.sbt.rgrtu.gol.cli.presentation.*;
import ru.sbt.rgrtu.gol.cli.controller.Controller;
import ru.sbt.rgrtu.gol.cli.controller.*;

public class Starter {

    public static void main(String[] args) {
//        ConfigurationProvider cpl = createHardCodedConfigurationProvider();
//        ConfigurationProvider cpl = createInlineConfigurationProvider();
        ConfigurationProvider cpl = createConfigurationPropertiesLoader();
        Gol gol = new Gol(cpl);
        //       Presentation presentation = new AtAndSpacePresentation(gol);
        //       Presentation presentation = new SmilePresentation(gol);
        Presentation presentation = new ColoredPresentation(gol);

 //       TimeProvider tmp = createHardCodedTimeProvider();
        TimeProvider tmp = createTimePropertiesLoader();

        //       Controller controller = new FrameByFrameController(gol, presentation);
        Controller controller = new TimedController(gol, presentation, tmp);
        controller.run();
    }

    private static TimeProvider createHardCodedTimeProvider() {
        return new HardCodedTimeProvider();
    }

    private static TimeProvider createTimePropertiesLoader() {
        return new TimePropertiesLoader("config.properties");
    }

    private static ConfigurationProvider createConfigurationPropertiesLoader() {
        return new ConfigurationPropertiesLoader("config.properties");
    }

    private static ConfigurationProvider createHardCodedConfigurationProvider() {
        return new HardCodedConfigurationProvider();
    }

    private static ConfigurationProvider createInlineConfigurationProvider() {
        return () -> {
            Configuration configuration = new Configuration(150, 35, 20180921L);
            return configuration;
        };
    }
}
