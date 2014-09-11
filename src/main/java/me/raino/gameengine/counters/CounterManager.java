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

    public int cancel(Class<? extends GameCounter> counter) {
        int result = 0;
        for (GameCounter cr : this.counters) {
            if (cr.getClass().isAssignableFrom(counter)) {
                cr.cancel();
                result++;
            }
        }
        return result;
    }

    public int cancelAll() {
        int result = 0;
        for (GameCounter cr : this.counters) {
            cr.stop();
            result++;
        }
        this.counters.clear();
        return result;
    }

    public boolean remove(GameCounter counter) {
        return counters.remove(counter);
    }

}
