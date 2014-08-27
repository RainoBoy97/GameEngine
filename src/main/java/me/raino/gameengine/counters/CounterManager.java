package me.raino.gameengine.counters;

import com.google.common.collect.Lists;

import java.util.List;

public final class CounterManager {

    private final List<GameCounter> counters;

    public CounterManager() {
        this.counters = Lists.newArrayList();
    }

    public void start(GameCounter counter, int count, int operand, int limit) {
        counters.add(counter.start(count, operand, limit));
    }

    public void start(GameCounter counter, int count, int operand) {
        this.start(counter, count, operand, 0);
    }

    public void start(GameCounter counter, int count) {
        this.start(counter, count, -1);
    }

    public void cancelAll() {
        for (GameCounter cr : this.counters)
            cr.stop();
        this.counters.clear();
    }

    public boolean remove(GameCounter counterItem) {
        return counters.remove(counterItem);
    }

}
