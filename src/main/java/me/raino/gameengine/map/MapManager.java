package me.raino.gameengine.map;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Sets;

public final class MapManager {

    private final File directory;
    private Set<GameMap> maps;

    public MapManager(File directory) {
        this.directory = directory;
        this.maps = Sets.newHashSet();
    }

    private void clean(File directory) {
        for (File f : directory.listFiles()) {
            String name = f.getName();
            if (!(name.equalsIgnoreCase("region") || name.equalsIgnoreCase("data") || name.equalsIgnoreCase("level.dat")))
                FileUtils.deleteQuietly(f);
        }
    }

    public File getDirectory() {
        return this.directory;
    }

    public Set<GameMap> getMaps() {
        return this.maps;
    }

}
