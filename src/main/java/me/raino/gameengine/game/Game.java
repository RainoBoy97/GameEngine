package me.raino.gameengine.game;

import me.raino.gameengine.counters.CounterManager;

public abstract class Game {

    private CounterManager counterManager = new CounterManager();

    public abstract void enable();

    public abstract void disable();

}
