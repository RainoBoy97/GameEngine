package me.raino.gameengine.counters;

import me.raino.gameengine.GameEngine;
import org.bukkit.scheduler.BukkitRunnable;

public final class CounterItem extends BukkitRunnable {

    private final CounterManager counterManager;
    private final CounterContext counter;
    private int count;
    private int operand;
    private int limit;

    public CounterItem(CounterManager counterManager, CounterContext counter) {
        this.counterManager = counterManager;
        this.counter = counter;
    }

    public CounterItem start(int count, int operand, int limit) {
        this.count = count;
        this.operand = operand;
        this.limit = limit;
        this.counter.onStart(count);
        this.runTaskTimer(GameEngine.get(), 0L, 20L);
        return this;
    }

    public CounterItem start(int count, int operand) {
        return this.start(count, operand, 0);
    }

    public CounterItem start(int count) {
        return this.start(count, -1);
    }

    public void cancel() {
        this.stop();
        this.counter.onCancel();
    }

    public void stop() {
        super.cancel();
    }

    @Override
    public void run() {
        if ((this.operand > 0 && this.count < this.limit) || (this.operand < 0 && this.count > this.limit)) {
            this.counter.onTick(this.count);
        } else {
            this.counter.onEnd();
            this.stop();
        }
        this.count += this.operand;
    }
}
