package me.raino.gameengine.game;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

public final class GameMeta {

    private final String main;
    private final String name;
    private final String description;

    public GameMeta(String main, String name, String description) {
        this.main = main;
        this.name = name;
        this.description = description;
    }

    public String getMain() {
        return this.main;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

}
