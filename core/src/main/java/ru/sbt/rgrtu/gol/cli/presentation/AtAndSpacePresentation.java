package ru.sbt.rgrtu.gol.cli.presentation;

import ru.sbt.rgrtu.gol.cli.game.Gol;

public class AtAndSpacePresentation implements Presentation {

    private final Gol gol;

    public AtAndSpacePresentation(Gol gol) {
        this.gol = gol;
    }

    @Override
    public void show() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("===== %1$05d =====", gol.getGeneration())).append("\n");
        for (int y = 0; y < gol.getSizeY(); y++) {
            for (int x = 0; x < gol.getSizeX(); x++) {
                out.append(gol.getPoint(x,y) ? "@" : " ");
            }
            out.append("\n");
        }
        System.out.println(out);
    }
}
