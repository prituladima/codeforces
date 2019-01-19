package com.prituladima.yaal.generated.collections.queue;

import com.prituladima.yaal.generated.collections.DoubleCollection;

public interface DoubleQueue extends DoubleCollection {
    default public double first() {
        return peek();
    }

    public double peek();

    public double poll();
}
