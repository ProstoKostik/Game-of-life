package ru.sbt.rgrtu.gol.cli.controller;

import ru.sbt.rgrtu.gol.cli.config.Configuration;
import ru.sbt.rgrtu.gol.cli.config.time.ConfigurationExtended;
import ru.sbt.rgrtu.gol.cli.game.Gol;
import ru.sbt.rgrtu.gol.cli.presentation.Presentation;

import java.util.Scanner;

/**
 * Runs simulation without user input, changing generations by timer.
 */
public class TimedController implements Controller {

    private final Gol gol;
    private final Presentation presentation;
    private ConfigurationExtended configuration;
    private volatile boolean stopped;
    private int sleep = 300;

    public TimedController(Gol gol, Presentation presentation) {
        this.gol = gol;
        this.presentation = presentation;
        if (gol.getConfigurationProvider().getConfiguration() instanceof ConfigurationExtended) {
            configuration = (ConfigurationExtended) gol.getConfigurationProvider().getConfiguration();
            sleep = configuration.getTime();
        }
    }

    @Override
    public void run() {
        new Thread(new Input()).start();

        gol.init();
        while (!stopped) {
            gol.nextStep();
            presentation.show();

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class Input implements Runnable {

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (!stopped) {
                scanner.nextLine();
                stopped = true;
            }
        }
    }
}
