package me.raino.gameengine.game;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GameManager {

    private Map<GameMeta, Game> games;

    public GameManager() {
        this.games = Maps.newHashMap();
    }

    public void registerGame(Game game) {
        Class<? extends Game> gameClass = game.getClass();
        GameMeta meta = gameClass.getAnnotation(GameMeta.class);
        Preconditions.checkNotNull(meta, gameClass.getSimpleName() + " must have GameMeta annotation");
        this.games.put(meta, game);
    }

}
