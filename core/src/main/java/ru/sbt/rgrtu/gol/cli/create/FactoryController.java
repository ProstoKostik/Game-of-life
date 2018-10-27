package ru.sbt.rgrtu.gol.cli.create;

import ru.sbt.rgrtu.gol.cli.config.time.TimeProvider;
import ru.sbt.rgrtu.gol.cli.controller.FrameByFrameController;
import ru.sbt.rgrtu.gol.cli.controller.TimedController;
import ru.sbt.rgrtu.gol.cli.create.type.TypeController;
import ru.sbt.rgrtu.gol.cli.game.Gol;
import ru.sbt.rgrtu.gol.cli.presentation.Presentation;

public class FactoryController implements Factory {

    @Override
    public Object create(Object... objects) {

        Gol gol = null;
        Presentation presentation = null;
        TimeProvider timeProvider = null;
        TypeController typeController = null;
        for (Object ob : objects) {
            if (ob instanceof Gol)
                gol = (Gol) ob;
            else if (ob instanceof Presentation)
                presentation = (Presentation) ob;
            else if (ob instanceof TimeProvider)
                timeProvider = (TimeProvider) ob;
            else if (ob instanceof TypeController)
                typeController = (TypeController) ob;
        }
        switch (typeController) {
            case FRAME:
                return new FrameByFrameController(gol, presentation);
            case TIMED:
                return new TimedController(gol, presentation, timeProvider);
            default:
                return null;
        }
    }
}
