package ru.sbt.rgrtu.gol.presentation;

import ru.sbt.rgrtu.gol.game.Gol;

import java.io.UnsupportedEncodingException;

public class SmilePresentation implements Presentation {

    private static final String SMILE = getSmile();
    private final Gol gol;

    private static String getSmile() {
        try {
            return new String(new byte[]{(byte)0xf0, (byte)0x9f, (byte)0x98, (byte)0x80},
                    "UTF-8"
            );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ":)";
    }

    public SmilePresentation(Gol gol) {
        this.gol = gol;
    }

    @Override
    public void show() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("===== %1$05d =====", gol.getGeneration())).append("\n");
        for (int y = 0; y < gol.getSizeY(); y++) {
            for (int x = 0; x < gol.getSizeX(); x++) {
                out.append(gol.getPoint(x,y) ? SMILE : " ");
            }
            out.append("\n");
        }
        System.out.println(out);
    }
}
