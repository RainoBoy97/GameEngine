package me.raino.gameengine.player;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;

public class GamePlayers {

    private static Map<String, GamePlayer> players = Maps.newHashMap();

    public static GamePlayer create(Player player) {
        return players.putIfAbsent(player.getName(), new GamePlayer(player));
    }

    public static GamePlayer remove(Player player) {
        return players.remove(player.getName());
    }

    public static GamePlayer get(Player player) {
        return players.get(player.getName());
    }

    public static GamePlayer get(String name) {
        return players.get(name);
    }

}
