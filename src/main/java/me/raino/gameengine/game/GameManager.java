package me.raino.gameengine.game;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import me.raino.gameengine.Log;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public final class GameManager {

    private List<Game> games;
    private Map<GameMeta, Game> gameMeta;
    private Map<Class<? extends Game>, Game> gameClasses;

    public GameManager() {
        this.games = Lists.newArrayList();
        this.gameMeta = Maps.newHashMap();
        this.gameClasses = Maps.newHashMap();
    }

    public void registerGame(Class<? extends Game> gameClass) {
        GameMeta gameMeta = gameClass.getAnnotation(GameMeta.class);
        Preconditions.checkNotNull(gameMeta, "Game must have GameMeta annotation");
        Game game = null;
        try {
            game = gameClass.getConstructor(GameMeta.class).newInstance(gameMeta);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            Log.exception(e);
        }
        this.games.add(game);
        this.gameMeta.put(gameMeta, game);
        this.gameClasses.put(gameClass, game);
    }

    public List<Game> getGames() {
        return ImmutableList.copyOf(this.games);
    }
}
