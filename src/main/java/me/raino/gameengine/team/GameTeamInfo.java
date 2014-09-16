package me.raino.gameengine.team;

import org.bukkit.ChatColor;

public final class GameTeamInfo {

    public static final GameTeamInfo OBSERVERS = new GameTeamInfo(TeamType.OBSERVING, "Observers", ChatColor.AQUA, -1);

    private TeamType type;
    private String name;
    private ChatColor color;
    private int max;

    public GameTeamInfo(TeamType type, String name, ChatColor color, int max) {
        this.type = type;
        this.name = name;
        this.color = color;
        this.max = max;
    }

    public TeamType getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public ChatColor getColor() {
        return this.color;
    }

    public int getMax() {
        return this.max;
    }

}
