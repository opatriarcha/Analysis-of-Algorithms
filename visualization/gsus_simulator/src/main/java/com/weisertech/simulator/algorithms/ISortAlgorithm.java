package com.weisertech.simulator.algorithms;

import com.weisertech.simulator.SortArray;

/**
 * Base interface for the sort algorithms
 *
 * @author The NearZero
 */
public interface ISortAlgorithm {
    public String getName();

    public long getDelay();

    public void setDelay(long delay);

    public void runSort(SortArray array);
}
