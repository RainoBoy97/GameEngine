package me.raino.gameengine;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class Log {

    private static final boolean debug = Config.General.DEBUG;
    private static final Logger log = GameEngine.get().getLogger();

    public static void info(String message, Object... parameters) {
        log.log(Level.INFO, message, parameters);
    }

    public static void warning(String message, Object... parameters) {
        log.log(Level.WARNING, message, parameters);
    }

    public static void severe(String message, Object... parameters) {
        log.log(Level.SEVERE, message, parameters);
    }

    public static void exception(Throwable throwable) {
        throwable.printStackTrace();
    }

    public static void debug(String message, Object... parameters) {
        if (debug)
           info("[DEBUG] " + message, parameters);
    }

}
