package ru.sbt.rgrtu.gol.cli.initialization;

import java.io.*;

public class InitializerFileLoader implements Initializer {

    private String path;
    private int countArrayRow = 0;
    private int countArrayColumn = 0;
    private File file = null;

    public InitializerFileLoader(String path) {
        this.path = path;
        initArraySize();
    }

    private void initArraySize() {
        try {
            file = new File(path);
            FileReader fr = new FileReader(path);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            countArrayColumn = line.length();
            while (line != null) {
                line = reader.readLine();
                countArrayRow++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean[][] createFirstPopulation() {
        int i = 0;
        boolean[][] arr = new boolean[countArrayColumn][countArrayRow];
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                if (line != null)
                    for (int j = 0; j < line.length(); j++) {
                        if (line.toCharArray()[j] == '*')
                            arr[j][i] = true;
                        else
                            arr[j][i] = false;
                    }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
