package me.raino.gameengine.game;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;

import com.google.common.collect.Lists;
import me.raino.gameengine.Log;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public final class GameManager {

    private List<Game> games;
    private Map<GameMeta, Game> gameMeta;
    private Map<Class<? extends Game>, Game> gameClasses;

    public GameManager() {
        this.games = Lists.newArrayList();
        this.gameMeta = Maps.newHashMap();
        this.gameClasses = Maps.newHashMap();
    }

    public void loadGames(File folder) {
        GameLoader loader = new GameLoader();
        for (Game game : loader.loadGames(folder))
            registerGame(game);
    }

    public void registerGame(Game game) {
        this.games.add(game);
        this.gameMeta.put(game.getMeta(), game);
        this.gameClasses.put(game.getClass(), game);
    }

}
