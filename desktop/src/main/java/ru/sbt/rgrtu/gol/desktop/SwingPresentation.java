package ru.sbt.rgrtu.gol.desktop;

import ru.sbt.rgrtu.gol.cli.game.Gol;
import ru.sbt.rgrtu.gol.cli.presentation.Presentation;
import ru.sbt.rgrtu.gol.desktop.listener.SwingPresentationListener;

import javax.swing.*;
import java.awt.*;

public class SwingPresentation implements Presentation {
    private JFrame frame;
    private Gol gol;
    private TextArea textArea;
    private SwingPresentationListener swingPresetnationListener;


    public SwingPresentation(Gol gol) {
        this.gol = gol;
        swingPresetnationListener = new SwingPresentationListener();
        frame = new JFrame();
        textArea = new TextArea();
        frame.setBounds(111, 111, 500, 400);
        frame.add(textArea);
        frame.addWindowListener(swingPresetnationListener);
        frame.setVisible(true);
    }

    @Override
    public void show() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("===== %1$05d =====", gol.getGeneration())).append("\n");
        for (int y = 0; y < gol.getSizeY(); y++) {
            for (int x = 0; x < gol.getSizeX(); x++) {
                out.append(gol.getPoint(x, y) ? "@" : " ");
            }
            out.append("\n");
        }
        textArea.setText(out.toString());
        frame.repaint();
    }
}
