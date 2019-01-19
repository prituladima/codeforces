package com.prituladima.yaal.generated.collections.set;

import com.prituladima.yaal.generated.collections.CharCollection;

public interface CharSet extends CharCollection {
    @Override
    default public int count(char value) {
        return contains(value) ? 1 : 0;
    }
}
