package ru.sbt.rgrtu.gol.cli.presentation;

import ru.sbt.rgrtu.gol.cli.game.Gol;

public class ColoredPresentation extends AbstractConsolePresentation implements Presentation {

    public ColoredPresentation(Gol gol) {
        super(gol);
    }

    @Override
    public void show() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("===== %1$05d =====", getGol().getGeneration())).append("\n");
        for (int y = 0; y < getGol().getSizeY(); y++) {
            for (int x = 0; x < getGol().getSizeX(); x++) {
                out.append(getGol().getPoint(x,y)
                        ? "\033[42m" // Green background
                        : "\033[40m" // Black background
                ).append(" ");
            }
            out.append("\033[0m").append("\n"); // reset
        }
        System.out.println(out);
    }
}
