package me.raino.gameengine;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class Log {

    private static final boolean DEBUG = Config.General.DEBUG;
    private static final Logger LOG = GameEngine.get().getLogger();

    public static void info(String message, Object... parameters) {
        LOG.log(Level.INFO, message, parameters);
    }

    public static void warning(String message, Object... parameters) {
        LOG.log(Level.WARNING, message, parameters);
    }

    public static void severe(String message, Object... parameters) {
        LOG.log(Level.SEVERE, message, parameters);
    }

    public static void exception(Throwable throwable) {
        throwable.printStackTrace();
    }

    public static void debug(String message, Object... parameters) {
        if (DEBUG)
           info("[DEBUG] " + message, parameters);
    }

}
