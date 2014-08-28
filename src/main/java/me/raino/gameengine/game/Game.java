package me.raino.gameengine.game;

import me.raino.gameengine.GameEngine;
import me.raino.gameengine.counters.CounterManager;
import me.raino.gameengine.game.logger.GameLogger;
import me.raino.gameengine.map.MapManager;

import java.io.File;

public abstract class Game {

    private GameMeta meta;
    private GameLogger logger;

    private MapManager mapManager;
    private CounterManager counterManager;

    protected Game(GameMeta meta) {
        this.meta = meta;
        this.logger = new GameLogger(meta);
        this.mapManager = new MapManager(new File(GameEngine.get().getDataFolder() + File.separator + meta.getName() + File.separator + "maps"));
        this.counterManager = new CounterManager();
    }

    public GameMeta getMeta() {
        return this.meta;
    }

    public GameLogger getLogger() {
        return this.logger;
    }

    public MapManager getMapManager() {
        return this.mapManager;
    }

    public CounterManager getCounterManager() {
        return this.counterManager;
    }

    public abstract void enable();

    public abstract void disable();

}
