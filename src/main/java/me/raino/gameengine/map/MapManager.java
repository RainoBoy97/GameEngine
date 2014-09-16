package me.raino.gameengine.map;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import me.raino.gameengine.Log;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.bukkit.World;

public final class MapManager {

    private final File directory;
    private Map<String, GameMap> maps;

    public MapManager(File directory) {
        this.directory = directory;
        this.maps = Maps.newHashMap();
    }

    private void clean(File directory) {
        for (File f : directory.listFiles()) {
            String name = f.getName();
            if (!(name.equalsIgnoreCase("region") || name.equalsIgnoreCase("data") || name.equalsIgnoreCase("level.dat"))) {
                try {
                    FileUtils.forceDelete(f);
                } catch (IOException e) {}
            }
        }
    }

    public void copy(GameMap map, File dest) {
        try {
            FileUtils.copyDirectory(map.getFolder(), dest);
        } catch (IOException e) {
            Log.exception(e);
        }
    }

    public File getDirectory() {
        return this.directory;
    }

    public Map<String, GameMap> getMaps() {
        return ImmutableMap.copyOf(this.maps);
    }

}
