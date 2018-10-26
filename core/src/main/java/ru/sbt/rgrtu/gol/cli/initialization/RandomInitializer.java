package ru.sbt.rgrtu.gol.cli.initialization;

import ru.sbt.rgrtu.gol.cli.config.Configuration;
import ru.sbt.rgrtu.gol.cli.config.ConfigurationProvider;

import java.util.Random;

public class RandomInitializer implements Initializer {

    private long seed;
    private int sizeX;
    private int sizeY;

    public RandomInitializer(ConfigurationProvider configurationProvider) {
        Configuration configuration = configurationProvider.getConfiguration();
        this.seed = configuration.getSeed();
        this.sizeX = configuration.getSizeX();
        this.sizeY = configuration.getSizeY();
    }

    @Override
    public boolean[][] createFirstPopulation() {
        boolean[][] current = new boolean[sizeX][sizeY];
        Random random = new Random(seed);
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                current[x][y] = random.nextBoolean();
            }
        }
        return current;
    }

}
