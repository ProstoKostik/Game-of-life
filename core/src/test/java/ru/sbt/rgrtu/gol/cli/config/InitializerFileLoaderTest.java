package ru.sbt.rgrtu.gol.cli.config;

import org.junit.jupiter.api.Test;
import ru.sbt.rgrtu.gol.cli.initialization.InitializerFileLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InitializerFileLoaderTest {

    @Test
    public void getFirstPopulation() {
        InitializerFileLoader initializerFileLoader = new InitializerFileLoader
                ("src//test//resources//test-border.txt");
        boolean[][] firstPopulation = initializerFileLoader.createFirstPopulation();

        assertEquals(4, firstPopulation[0].length);
        assertEquals(11, firstPopulation.length);
    }

}
