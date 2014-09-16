package me.raino.gameengine.player;

import com.google.common.base.Preconditions;
import me.raino.gameengine.team.GameTeam;
import me.raino.gameengine.team.GameTeamInfo;
import org.bukkit.entity.Player;

import java.lang.ref.WeakReference;
import java.text.MessageFormat;

public final class GamePlayer {

    private WeakReference<Player> player;

    private GameTeam team;

    public GamePlayer(Player player) {
        this.player = new WeakReference<Player>(player);
    }

    public void setTeam(GameTeam team) {
        this.team = team;
    }

    public Player getBukkit() {
        Player player = this.player.get();
        Preconditions.checkNotNull(player, "Tried to get a null player");
        return player;
    }

    public GameTeam getTeam() {
        return this.team;
    }

    public void sendMessage(String message, Object... arguments) {
        this.getBukkit().sendMessage(MessageFormat.format(message, arguments));
    }

}
