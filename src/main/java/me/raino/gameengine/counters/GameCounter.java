package me.raino.gameengine.counters;

import me.raino.gameengine.GameEngine;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class GameCounter extends BukkitRunnable {

    private final CounterManager counterManager;
    private int count;
    private int operand;
    private int limit;

    public GameCounter(CounterManager counterManager) {
        this.counterManager = counterManager;
    }

    public GameCounter start(int count, int operand, int limit) {
        this.count = count;
        this.operand = operand;
        this.limit = limit;
        this.onStart(count);
        this.runTaskTimer(GameEngine.get(), 0L, 20L);
        return this;
    }

    public GameCounter start(int count, int operand) {
        return this.start(count, operand, 0);
    }

    public GameCounter start(int count) {
        return this.start(count, -1);
    }

    public void cancel() {
        this.stop();
        this.onCancel();
    }

    public void stop() {
        super.cancel();
    }

    @Override
    public void run() {
        if ((this.operand > 0 && this.count < this.limit) || (this.operand < 0 && this.count > this.limit)) {
            this.onTick(this.count);
        }
        else {
            this.onEnd();
            this.stop();
        }
        this.count += this.operand;
    }

    public abstract void onStart(int seconds);

    public abstract void onTick(int seconds);

    public abstract void onCancel();

    public abstract void onEnd();

}
