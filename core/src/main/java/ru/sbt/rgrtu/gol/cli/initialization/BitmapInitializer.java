package ru.sbt.rgrtu.gol.cli.initialization;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class BitmapInitializer implements Initializer {

    private String file;

    public BitmapInitializer(String file) {
        this.file = file;
    }

    @Override
    public boolean[][] createFirstPopulation() {
        boolean[][] firstPopulation = new boolean[1][1];
        try {
            BufferedImage image = ImageIO.read(new File(file));
            firstPopulation = new boolean[image.getWidth()][image.getHeight()];

            for (int xPixel = 0; xPixel < image.getWidth(); xPixel++) {
                for (int yPixel = 0; yPixel < image.getHeight(); yPixel++) {
                    int color = image.getRGB(xPixel, yPixel);
                    if (color == Color.BLACK.getRGB())
                        firstPopulation[xPixel][yPixel] = true;
                    else
                        firstPopulation[xPixel][yPixel] = false;
                }
            }
            return firstPopulation;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return firstPopulation;
    }
}
