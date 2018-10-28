package ru.sbt.rgrtu.gol.desktop.presentation;

import ru.sbt.rgrtu.gol.cli.game.Gol;
import ru.sbt.rgrtu.gol.cli.presentation.Presentation;
import ru.sbt.rgrtu.gol.desktop.listener.SwingPresentationListener;

import javax.swing.*;

public class SwingPresentation implements Presentation {
    private JFrame frame;
    private SwingPresentationListener swingPresetnationListener;
    private GameView gameView;


    public SwingPresentation(Gol gol) {
        swingPresetnationListener = new SwingPresentationListener();
        gameView = new GameView(gol);
        frame = new JFrame();
        frame.setBounds(111, 111, 1200, 600);
        frame.add(gameView);
        frame.addWindowListener(swingPresetnationListener);
        frame.setVisible(true);
    }

    @Override
    public void show() {
        frame.repaint();
    }
}
