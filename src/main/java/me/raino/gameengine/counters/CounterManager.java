package me.raino.gameengine.counters;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * CounterManager stores all the active counters, and provides a method to cancel the active counters
 */
public final class CounterManager {

    // List of all active counters
    private final List<CounterItem> counters;

    public CounterManager() {
        this.counters = Lists.newArrayList();
    }

    /**
     * Starts a countdown
     *
     * @param counter the counter to run
     * @param count   the count to start at
     * @param operand the amount to add/subtract
     * @param limit   the limit it should stop at
     */
    public void start(CounterContext counter, int count, int operand, int limit) {
        counters.add(new CounterItem(this, counter).start(count, operand, limit));
    }

    /**
     * Starts a countdown (defaults limit to 0)
     *
     * @param counter the counter to run
     * @param count   the count to start at
     * @param operand the amount to add/subtract
     */
    public void start(CounterContext counter, int count, int operand) {
        this.start(counter, count, operand, 0);
    }

    /**
     * Starts a countdown (defaults limit to 0 and operand to -1)
     *
     * @param counter the counter to run
     * @param count   the count to start at
     */
    public void start(CounterContext counter, int count) {
        this.start(counter, count, -1);
    }

    /**
     * Cancels all the active counters
     */
    public void cancelAll() {
        for (CounterItem cr : this.counters)
            cr.stop();
        this.counters.clear();
    }

    /**
     * Removes a specified counter from the list of active counters
     *
     * @param counterItem the counter to remove
     * @return if the counter was removed or not
     */
    public boolean remove(CounterItem counterItem) {
        return counters.remove(counterItem);
    }

}
