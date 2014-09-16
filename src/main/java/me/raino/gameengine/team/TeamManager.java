package me.raino.gameengine.team;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.bukkit.ChatColor;

import java.util.List;

public final class TeamManager {

    private List<GameTeamInfo> teams;

    public TeamManager() {
        this.teams = Lists.newArrayList();
    }

    public void register(String name, ChatColor color, int max) {
        this.teams.add(new GameTeamInfo(TeamType.PARTIICPATING, name, color, max));
    }

    public void register(String name, ChatColor color) {
        this.register(name, color, -1);
    }

    public List<GameTeamInfo> getTeams() {
        return ImmutableList.copyOf(this.teams);
    }

}
