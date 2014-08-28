package me.raino.gameengine;

import me.raino.gameengine.game.GameManager;

import org.bukkit.plugin.java.JavaPlugin;

public class GameEngine extends JavaPlugin {

    private static GameEngine instance;

    private static GameManager gameManager;

    @Override
    public void onDisable() {
        GameEngine.instance = null;
    }

    @Override
    public void onEnable() {
        GameEngine.instance = this;
    }

    public static GameEngine get() {
        return GameEngine.instance;
    }

    public static GameManager getGameManager() {
        return GameEngine.gameManager;
    }

}
