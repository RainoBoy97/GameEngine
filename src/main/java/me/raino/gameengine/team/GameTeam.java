package me.raino.gameengine.team;

import com.google.common.collect.Lists;
import me.raino.gameengine.match.Match;
import me.raino.gameengine.player.GamePlayer;

import java.util.List;

public final class GameTeam {

    private GameTeamInfo info;
    private Match match;

    private List<GamePlayer> members;

    public GameTeam(GameTeamInfo info, Match match) {
        this.info = info;
        this.match = match;

        this.members = Lists.newArrayList();
    }

    public GameTeamInfo getInfo() {
        return this.info;
    }

    public Match getMatch() {
        return this.match;
    }

    public boolean isObserving() {
        return this.info.getType() == TeamType.OBSERVING || !this.match.isRunning();
    }

    public boolean isParticipating() {
        return this.info.getType() == TeamType.PARTIICPATING && this.match.isRunning();
    }

}
