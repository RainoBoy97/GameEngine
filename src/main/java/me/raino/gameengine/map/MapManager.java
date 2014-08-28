package me.raino.gameengine.map;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.io.FileUtils;

public final class MapManager {

    private final File directory;
    private Set<GameMap> maps;

    public MapManager(File directory) {
        this.directory = directory;
        this.maps = Sets.newHashSet();
    }

    private void clean(File directory) {
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return !(name.equalsIgnoreCase("region") || name.equalsIgnoreCase("data") || name.equalsIgnoreCase("level.dat"));
            }
        };
        for (File f : directory.listFiles(filter))
            FileUtils.deleteQuietly(f);
    }

    public File getDirectory() {
        return this.directory;
    }

    public Set<GameMap> getMaps() {
        return this.maps;
    }
    
}
