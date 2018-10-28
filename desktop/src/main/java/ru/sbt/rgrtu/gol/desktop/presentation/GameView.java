package ru.sbt.rgrtu.gol.desktop.presentation;

import ru.sbt.rgrtu.gol.cli.game.Gol;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameView extends JPanel {

    private Gol gol;
    private Image image;

    public GameView(Gol gol) {
        this.gol = gol;
        try {
            image = ImageIO.read(new File("desktop//src//main//resources//human.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int y = 0; y < gol.getSizeY(); y++) {
            for (int x = 0; x < gol.getSizeX(); x++) {
                if (gol.getPoint(x, y))
                    g.drawImage(image, x * 20, y * 40, null);
            }
        }
    }
}
