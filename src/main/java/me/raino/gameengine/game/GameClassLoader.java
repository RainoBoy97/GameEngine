package me.raino.gameengine.game;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public final class GameClassLoader extends URLClassLoader {

    private Game game;

    public GameClassLoader(final File file, GameMeta meta) throws MalformedURLException {
        super(new URL[] { file.toURI().toURL() }, file.getClass().getClassLoader());
        try {
            Class<?> clazz = Class.forName(meta.getMain());
            Class<? extends Game> gameClass = clazz.asSubclass(Game.class);
            this.game = gameClass.getConstructor(GameMeta.class).newInstance(meta);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {}
    }

    public Game getGame() {
        return this.game;
    }
}
