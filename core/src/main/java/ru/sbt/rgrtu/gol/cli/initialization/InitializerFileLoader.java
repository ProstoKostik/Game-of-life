package ru.sbt.rgrtu.gol.cli.initialization;

import java.io.*;

public class InitializerFileLoader implements Initializer {

    private String file;

    public InitializerFileLoader(String file) {
        this.file = file;
    }

    private int[] getArraySize() {
        int i = 0;
        int j = 0;
        try {
            File file = new File(this.file);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            j = line.length();
            while (line != null) {
                line = reader.readLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[]{i, j};
    }

    @Override
    public boolean[][] createFirstPopulation() {
        int i = 0;
        boolean[][] arr = new boolean[getArraySize()[1]][getArraySize()[0]];
        try {
            File file = new File(this.file);
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
