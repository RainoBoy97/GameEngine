package me.raino.gameengine;

import org.bukkit.configuration.Configuration;

import java.util.List;

public final class Config {

    private static Configuration config;

    static {
        GameEngine gameEngine = GameEngine.get();
        gameEngine.getConfig().options().copyDefaults(true);
        gameEngine.saveConfig();
        config = gameEngine.getConfig();
    }

    public static class General {

        public static final boolean DEBUG = config.getBoolean("debug", false);

    }

}
