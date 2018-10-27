package ru.sbt.rgrtu.gol.cli.create;

import ru.sbt.rgrtu.gol.cli.create.type.TypePresentation;
import ru.sbt.rgrtu.gol.cli.game.Gol;
import ru.sbt.rgrtu.gol.cli.presentation.AtAndSpacePresentation;
import ru.sbt.rgrtu.gol.cli.presentation.ColoredPresentation;
import ru.sbt.rgrtu.gol.cli.presentation.SmilePresentation;

public class FactoryPresentation implements Factory {

    @Override
    public Object create(Object... objects) {
        Gol gol = null;
        TypePresentation typePresentation = null;
        for (Object ob : objects) {
            if (ob instanceof Gol)
                gol = (Gol) ob;
            else if (ob instanceof TypePresentation)
                typePresentation = (TypePresentation) ob;
        }
        switch (typePresentation) {
            case SMILE:
                return new SmilePresentation(gol);
            case COLORED:
                return new ColoredPresentation(gol);
            case AT_AND_SPACE:
                return new AtAndSpacePresentation(gol);
            default:
                return null;
        }

    }
}
