package com.prituladima.yaal.generated.collections.set;

import com.prituladima.yaal.generated.collections.LongCollection;

public interface LongSet extends LongCollection {
    @Override
    default public int count(long value) {
        return contains(value) ? 1 : 0;
    }
}
