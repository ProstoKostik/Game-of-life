package ru.sbt.rgrtu.gol.cli.controller;

import ru.sbt.rgrtu.gol.cli.config.time.TimeProvider;
import ru.sbt.rgrtu.gol.cli.game.Gol;
import ru.sbt.rgrtu.gol.cli.presentation.Presentation;

import java.util.Scanner;

/**
 * Runs simulation without user input, changing generations by timer.
 */
public class TimedController implements Controller {

    private final Gol gol;
    private final Presentation presentation;
    private volatile boolean stopped;
    private int sleep;

    public TimedController(Gol gol, Presentation presentation, TimeProvider timeProvider) {
        this.gol = gol;
        this.presentation = presentation;
        sleep = timeProvider.getTime().getSleep();
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
