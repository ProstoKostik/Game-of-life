package ru.sbt.rgrtu.gol.cli.config.time;

public class Time {
    private int sleep;

    public Time(){
    }

    public Time(int sleep) {
        this.sleep = sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public int getSleep() {

        return sleep;
    }
}
