package me.raino.gameengine.map;

import com.google.common.collect.Lists;

import java.util.List;

public final class MapManager {

    private List<GameMap> maps;

    public MapManager() {
        this.maps = Lists.newArrayList();
    }

    public List<GameMap> getMaps() {
        return this.maps;
    }
}
