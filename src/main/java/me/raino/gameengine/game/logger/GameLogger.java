package me.raino.gameengine.game.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

import me.raino.gameengine.Config;
import me.raino.gameengine.game.GameMeta;
import org.apache.commons.lang.StringUtils;

public final class GameLogger {

    private static final boolean DEBUG = Config.General.DEBUG;

    private Logger logger;
    
    public GameLogger(GameMeta meta) {
        this.logger = Logger.getLogger(meta.name());
    }
    
    public void info(String message, Object... parameters) {
        this.logger.log(Level.INFO, message, parameters);
    }

    public void warning(String message, Object... parameters) {
        this.logger.log(Level.WARNING, message, parameters);
    }

    public void severe(String message, Object... parameters) {
        this.logger.log(Level.SEVERE, message, parameters);
    }

    public void exception(Throwable throwable) {
        throwable.printStackTrace();
    }

    public void debug(String message, Object... parameters) {
        if (DEBUG)
            this.info("[DEBUG] " + message, parameters);
    }
    
}
