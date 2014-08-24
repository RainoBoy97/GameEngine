package me.raino.gameengine;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main Bukkit class
 */
public class GameEngine extends JavaPlugin {

    // Singleton instance of GameEngine.java
    private static GameEngine instance;

    @Override
    public void onDisable() {
        GameEngine.instance = null;
    }

    @Override
    public void onEnable() {
        GameEngine.instance = this;
    }

    /**
     * Gets the current instance of GameEngine
     *
     * @return the GameEngine instance
     */
    public static GameEngine get() {
        return GameEngine.instance;
    }

}
