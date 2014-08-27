package me.raino.gameengine.game;

import java.util.Map;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import me.raino.gameengine.Log;

public final class GameManager {

    private Set<Game> games;
    private Map<GameMeta, Game> gameMeta;
    private Map<Class<? extends Game>, Game> gameClasses;

    public GameManager() {
        this.games = Sets.newHashSet();
        this.gameMeta = Maps.newHashMap();
        this.gameClasses = Maps.newHashMap();
    }

    public void registerGame(Class<? extends Game> gameClass) {
        GameMeta meta = gameClass.getAnnotation(GameMeta.class);
        Preconditions.checkNotNull(meta, gameClass.getSimpleName() + " must have GameMeta annotation");
        Game game = null;
        try {
            game = gameClass.getConstructor(GameMeta.class).newInstance(meta);
        } catch(Exception e) {
            Log.exception(e);
        }
        this.games.add(game);
        this.gameMeta.put(meta, game);
        this.gameClasses.put(gameClass, game);
    }

}
