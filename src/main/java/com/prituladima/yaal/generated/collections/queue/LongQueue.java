package com.prituladima.yaal.generated.collections.queue;

import com.prituladima.yaal.generated.collections.LongCollection;

public interface LongQueue extends LongCollection {
    default public long first() {
        return peek();
    }

    public long peek();

    public long poll();
}
