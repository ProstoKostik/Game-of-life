package ru.sbt.rgrtu.gol.cli.presentation;

import ru.sbt.rgrtu.gol.cli.game.Gol;

public abstract class AbstractConsolePresentation implements Presentation {
    private final Gol gol;
    private String[] symbol;

    public AbstractConsolePresentation(Gol gol, String... symbol) {
        this.gol = gol;
        this.symbol = symbol;
    }

    protected String[] getSymbol() {
        return symbol;
    }

    public Gol getGol() {
        return gol;
    }

    public void setSymbol(String[] symbol) {
        this.symbol = symbol;
    }

    @Override
    public void show() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("===== %1$05d =====", getGol().getGeneration())).append("\n");
        for (int y = 0; y < getGol().getSizeY(); y++) {
            for (int x = 0; x < getGol().getSizeX(); x++) {
                out.append(getGol().getPoint(x, y) ? symbol[0] : " ");
            }
            out.append("\n");
        }
        System.out.println(out);
    }
}
