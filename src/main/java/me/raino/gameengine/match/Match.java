package me.raino.gameengine.match;

import me.raino.gameengine.game.Game;
import me.raino.gameengine.map.GameMap;

import me.raino.gameengine.team.GameTeam;
import me.raino.gameengine.team.GameTeamInfo;
import org.bukkit.World;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Match {

    private final int id;
    private final Game game;
    private final GameMap map;
    private final World world;

    private GameTeam defaultTeam;
    private List<GameTeam> teams;

    private MatchState state;

    public Match(int id, Game game, GameMap map, World world) {
        this.id = id;
        this.game = game;
        this.map = map;
        this.world = world;

        this.defaultTeam = new GameTeam(GameTeamInfo.OBSERVERS, this);
        this.teams = game.getTeamManager().getTeams().stream().map(info -> new GameTeam(info, this)).collect(Collectors.toList());

        this.setState(MatchState.IDLE);
    }

    public boolean isRunning() {
        return this.state == MatchState.RUNNING;
    }

    public void setState(MatchState state) {
        this.state = state;
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

    public GameTeam getDefaultTeam() {
        return this.defaultTeam;
    }

    public List<GameTeam> getTeams() {
        return this.teams;
    }

    public MatchState getState() {
        return this.state;
    }
}
