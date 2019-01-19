package com.prituladima.yaal.generated.collections.queue;

import com.prituladima.yaal.generated.collections.IntCollection;

public interface IntQueue extends IntCollection {
    default public int first() {
        return peek();
    }

    public int peek();

    public int poll();
}
