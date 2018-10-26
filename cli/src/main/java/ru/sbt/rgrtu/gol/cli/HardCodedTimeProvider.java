package ru.sbt.rgrtu.gol.cli;

import ru.sbt.rgrtu.gol.cli.config.time.Time;
import ru.sbt.rgrtu.gol.cli.config.time.TimeProvider;

public class HardCodedTimeProvider implements TimeProvider {

    @Override
    public Time getTime() {
        return new Time(400);
    }
}
