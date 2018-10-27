package ru.sbt.rgrtu.gol.cli.create;

import ru.sbt.rgrtu.gol.cli.config.ConfigurationProvider;
import ru.sbt.rgrtu.gol.cli.create.type.TypeInitializer;
import ru.sbt.rgrtu.gol.cli.initialization.BitmapInitializer;
import ru.sbt.rgrtu.gol.cli.initialization.InitializerFileLoader;
import ru.sbt.rgrtu.gol.cli.initialization.RandomInitializer;

public class FactoryInitializer implements Factory {

    @Override
    public Object create(Object... objects) {
        String path = null;
        TypeInitializer type = null;
        ConfigurationProvider configurationProvider = null;
        for (Object ob : objects) {
            if (ob instanceof String)
                path = ob.toString();
            else if (ob instanceof TypeInitializer)
                type = (TypeInitializer) ob;
            else if (ob instanceof ConfigurationProvider)
                configurationProvider = (ConfigurationProvider) ob;
        }
        switch (type) {
            case BITMAP:
                return new BitmapInitializer(path);
            case RANDOM:
                return new RandomInitializer(configurationProvider);
            case FILE_LOADER:
                return new InitializerFileLoader(path);
            default:
                return null;
        }
    }
}
