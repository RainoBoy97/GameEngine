package me.raino.gameengine.game;

import java.io.File;

import me.raino.gameengine.GameEngine;
import me.raino.gameengine.counters.CounterManager;
import me.raino.gameengine.game.logger.GameLogger;
import me.raino.gameengine.map.MapManager;
import me.raino.gameengine.team.TeamManager;

public abstract class Game {

    private GameMeta meta;
    private GameLogger logger;

    private MapManager mapManager;
    private TeamManager teamManager;
    private CounterManager counterManager;

    public Game(GameMeta meta) {
        this.meta = meta;
        this.logger = new GameLogger(meta);
        this.mapManager = new MapManager(new File(GameEngine.get().getDataFolder() + File.separator + meta.name() + File.separator + "maps"));
        this.teamManager = new TeamManager();
        this.counterManager = new CounterManager();
    }

    public GameMeta getMeta() {
        return this.meta;
    }

    public GameLogger getLogger() {
        return this.logger;
    }

    public TeamManager getTeamManager() {
        return this.teamManager;
    }

    public MapManager getMapManager() {
        return this.mapManager;
    }

    public CounterManager getCounterManager() {
        return this.counterManager;
    }

    public abstract void onEnable();

    public abstract void onDisable();

}
