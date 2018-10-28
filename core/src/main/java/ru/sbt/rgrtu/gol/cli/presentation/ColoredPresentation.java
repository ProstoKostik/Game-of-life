package ru.sbt.rgrtu.gol.cli.presentation;

import ru.sbt.rgrtu.gol.cli.game.Gol;
import ru.sbt.rgrtu.gol.cli.presentation.AbstractConsolePresentation;
import ru.sbt.rgrtu.gol.cli.presentation.Presentation;

public class ColoredPresentation extends AbstractConsolePresentation implements Presentation {

    private static final String GREEN_BACKGROUND = "\033[42m";
    private static final String BLACK_BACKGROUND = "\033[40m";
    private static final String RESET = "\033[0m";

    public ColoredPresentation(Gol gol) {
        super(gol);
    }

    @Override
    public void show() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("===== %1$05d =====", getGol().getGeneration())).append("\n");
        for (int y = 0; y < getGol().getSizeY(); y++) {
            for (int x = 0; x < getGol().getSizeX(); x++) {
                out.append(getGol().getPoint(x, y)
                        ? GREEN_BACKGROUND // Green background
                        : BLACK_BACKGROUND // Black background
                ).append(" ");
            }
            out.append(RESET).append("\n"); // reset
        }
        System.out.println(out);
    }
}
