package me.raino.gameengine.counters;

public interface CounterContext {

    public void onStart(int seconds);

    public void onTick(int seconds);

    public void onCancel();

    public void onEnd();

}
