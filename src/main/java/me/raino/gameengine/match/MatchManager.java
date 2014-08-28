package me.raino.gameengine.match;

import com.google.common.collect.Maps;
import me.raino.gameengine.Config;
import me.raino.gameengine.game.Game;
import me.raino.gameengine.map.GameMap;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

import java.io.File;
import java.util.Map;

public final class MatchManager {

    private int matchId = 0;

    private Map<World, Match> matches;

    protected MatchManager() {
        this.matches = Maps.newConcurrentMap();
    }

    public Match newMatch(Game game, GameMap map) {
        String name = Config.Match.PREFIX + "id here";
        File dist = new File(Bukkit.getWorldContainer(), name);
        World world = Bukkit.createWorld(new WorldCreator(name).type(WorldType.FLAT));
        Match match = new Match(matchId, game, map, null);
        return match;
    }

}
