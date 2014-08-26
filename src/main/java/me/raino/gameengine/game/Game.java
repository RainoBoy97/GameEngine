package me.raino.gameengine.game;

import me.raino.gameengine.counters.CounterManager;
import me.raino.gameengine.game.logger.GameLogger;

public abstract class Game {

    private GameMeta meta;
    private GameLogger logger;

    private CounterManager counterManager;

    protected Game(GameMeta meta) {
        this.meta = meta;
        this.logger = new GameLogger(meta);
        this.counterManager = new CounterManager();
    }

    public GameMeta getMeta() {
        return this.meta;
    }

    public GameLogger getLogger() {
        return this.logger;
    }

    public CounterManager getCounterManager() {
        return this.counterManager;
    }

    public abstract void enable();

    public abstract void disable();

}
