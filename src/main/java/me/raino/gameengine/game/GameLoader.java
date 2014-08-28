package me.raino.gameengine.game;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.List;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import net.minecraft.util.org.apache.commons.io.IOUtils;

import org.json.JSONObject;

import com.google.common.collect.Lists;

public final class GameLoader {

    public static final String GAME_MANIFEST = "game.json";

    public List<Game> loadGames(File folder) {
        List<Game> games = Lists.newArrayList();
        for (File f : folder.listFiles()) {
            if (f.getName().endsWith(".jar")) {
                games.add(loadGame(f));
            }
        }
        return games;
    }

    private Game loadGame(File file) {
        JarFile jar = null;
        try {
            jar = new JarFile(file);
        } catch (IOException e) {
            return null;
        }
        ZipEntry manifest = jar.getEntry(GAME_MANIFEST);
        JSONObject config;
        try {
            InputStream stream = jar.getInputStream(manifest);
            config = new JSONObject(IOUtils.toString(stream));
        } catch (IOException e) {
            return null;
        }
        String main = config.getString("main");
        String name = config.getString("name");
        String description = config.getString("description");
        GameMeta meta = new GameMeta(main, name, description);
        GameClassLoader loader;
        try {
            loader = new GameClassLoader(file, meta);
        } catch (MalformedURLException e) {
            return null;
        }
        return loader.getGame();
    }

}
