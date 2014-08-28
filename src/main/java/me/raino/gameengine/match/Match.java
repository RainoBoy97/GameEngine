package me.raino.gameengine.match;

import me.raino.gameengine.game.Game;
import me.raino.gameengine.map.GameMap;

import org.bukkit.World;

public final class Match {

    private final int id;
    private final Game game;
    private final GameMap map;
    private final World world;

    private MatchState state;

    public Match(int id, Game game, GameMap map, World world) {
        this.id = id;
        this.game = game;
        this.map = map;
        this.world = world;

        this.state = MatchState.IDLE;
    }

    public int getId() {
        return this.id;
    }

    public Game getGame() {
        return this.game;
    }

    public GameMap getMap() {
        return this.map;
    }

    public World getWorld() {
        return this.world;
    }

    public MatchState getState() {
        return this.state;
    }
}
