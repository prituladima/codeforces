package com.prituladima.yaal.generated.collections.set;

import com.prituladima.yaal.generated.collections.IntCollection;

public interface IntSet extends IntCollection {
    @Override
    default public int count(int value) {
        return contains(value) ? 1 : 0;
    }
}
