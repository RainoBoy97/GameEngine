package me.raino.gameengine.map;

import me.raino.gameengine.game.Game;

import java.io.File;

public final class GameMap {

    private final Game game;
    private final File folder;

    public GameMap(Game game, File folder) {
        this.game = game;
        this.folder = folder;
    }

    public Game getGame() {
        return this.game;
    }

    public File getFolder() {
        return this.folder;
    }

}
