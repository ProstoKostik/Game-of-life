package ru.sbt.rgrtu.gol.cli;

import ru.sbt.rgrtu.gol.cli.config.Configuration;
import ru.sbt.rgrtu.gol.cli.config.ConfigurationPropertiesLoader;
import ru.sbt.rgrtu.gol.cli.config.ConfigurationProvider;
import ru.sbt.rgrtu.gol.cli.config.time.TimePropertiesLoader;
import ru.sbt.rgrtu.gol.cli.config.time.TimeProvider;
import ru.sbt.rgrtu.gol.cli.game.Gol;
import ru.sbt.rgrtu.gol.cli.initialization.BitmapInitializer;
import ru.sbt.rgrtu.gol.cli.initialization.Initializer;
import ru.sbt.rgrtu.gol.cli.initialization.InitializerFileLoader;
import ru.sbt.rgrtu.gol.cli.initialization.RandomInitializer;
import ru.sbt.rgrtu.gol.cli.presentation.Presentation;
import ru.sbt.rgrtu.gol.cli.presentation.*;
import ru.sbt.rgrtu.gol.cli.controller.Controller;
import ru.sbt.rgrtu.gol.cli.controller.*;
import ru.sbt.rgrtu.gol.desktop.SwingPresentation;

public class Starter {

    public static void main(String[] args) {
//        ConfigurationProvider cpl = createHardCodedConfigurationProvider();
//        ConfigurationProvider cpl = createInlineConfigurationProvider();
//        ConfigurationProvider cpl = createConfigurationPropertiesLoader();

<<<<<<< HEAD
        //       Initializer init = (RandomInitializer) factoryInitializer.create(TypeInitializer.RANDOM, cpl);
        Initializer init = (InitializerFileLoader) factoryInitializer.create(TypeInitializer.FILE_LOADER,
                "cli//src//main//resources//border.txt");
=======
        //         Initializer init = new RandomInitializer(cpl);

        Initializer init = new InitializerFileLoader("cli//src//main//resources//border.txt");
>>>>>>> master

        //          Initializer init = new BitmapInitializer("cli//src//main//resources//initImage.png");

        Gol gol = new Gol(init);
<<<<<<< HEAD
 //       Presentation presentation = (AtAndSpacePresentation) factoryPresentation.create(gol, TypePresentation.AT_AND_SPACE);
        //       Presentation presentation = (SmilePresentation) factoryPresentation.create(gol, TypePresentation.SMILE);
//        Presentation presentation = (ColoredPresentation) factoryPresentation.create(gol, TypePresentation.COLORED);
        Presentation presentation = (SwingPresentation) factoryPresentation.create(gol, TypePresentation.SWING);
=======
        // Presentation presentation = new AtAndSpacePresentation(gol);
        //      Presentation presentation = new SmilePresentation(gol);
        //       Presentation presentation = new ColoredPresentation(gol);
        Presentation presentation = new SwingPresentation(gol);
>>>>>>> master

        //       TimeProvider tmp = createHardCodedTimeProvider();
        TimeProvider tmp = createTimePropertiesLoader();

        //   Controller controller = new FrameByFrameController(gol, presentation);
        Controller controller = new TimedController(gol, presentation, tmp);
        controller.run();
    }

    private static Initializer createRandomInitializer(ConfigurationProvider cpl) {
        return new RandomInitializer(cpl);
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
