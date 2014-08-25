package me.raino.gameengine.game;

import java.util.Map;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public final class GameManager {

    private Set<Game> games;
    private Map<GameMeta, Game> gameMeta;
    private Map<Class<? extends Game>, Game> gameClasses;

    public GameManager() {
        this.games = Sets.newHashSet();
        this.gameMeta = Maps.newHashMap();
        this.gameClasses = Maps.newHashMap();
    }

    public void registerGame(Game game) {
        Class<? extends Game> gameClass = game.getClass();
        GameMeta meta = gameClass.getAnnotation(GameMeta.class);
        Preconditions.checkNotNull(meta, gameClass.getSimpleName() + " must have GameMeta annotation");
        this.games.add(game);
        this.gameMeta.put(meta, game);
        this.gameClasses.put(gameClass, game);
    }

}
