package me.raino.gameengine;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class Log {

    private final boolean debug = Config.General.DEBUG;
    private final Logger log = GameEngine.get().getLogger();

    public void info(String message, Object... parameters) {
        log.log(Level.INFO, message, parameters);
    }

    public void warning(String message, Object... parameters) {
        log.log(Level.WARNING, message, parameters);
    }

    public void severe(String message, Object... parameters) {
        log.log(Level.SEVERE, message, parameters);
    }

    public void exception(Throwable throwable) {
        throwable.printStackTrace();
    }

    public void debug(String message, Object... parameters) {
        if (debug)
           info("[DEBUG] " + message, parameters);
    }

}
