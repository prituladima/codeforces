package com.prituladima.yaal.generated.collections.queue;

import com.prituladima.yaal.generated.collections.CharCollection;

public interface CharQueue extends CharCollection {
    default public char first() {
        return peek();
    }

    public char peek();

    public char poll();
}
