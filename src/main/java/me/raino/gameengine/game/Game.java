package me.raino.gameengine.game;

import me.raino.gameengine.counters.CounterManager;

public abstract class Game {

    private CounterManager counterManager;

    public Game() {
        this.counterManager = new CounterManager();
    }

}
