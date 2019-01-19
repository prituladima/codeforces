package com.prituladima.yaal.generated.collections.set;

import com.prituladima.yaal.generated.collections.DoubleCollection;

public interface DoubleSet extends DoubleCollection {
    @Override
    default public int count(double value) {
        return contains(value) ? 1 : 0;
    }
}
