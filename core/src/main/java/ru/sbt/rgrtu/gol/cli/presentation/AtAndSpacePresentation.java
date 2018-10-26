package ru.sbt.rgrtu.gol.cli.presentation;

import ru.sbt.rgrtu.gol.cli.game.Gol;

public class AtAndSpacePresentation extends AbstractConsolePresentation implements Presentation {

    private static final String SYMBOL = "@";

    public AtAndSpacePresentation(Gol gol) {
        super(gol, SYMBOL);
    }
}
