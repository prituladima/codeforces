package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface LongLongPredicate {
    public boolean value(long first, long second);

    default public LongFilter setSecond(long second) {
        return v -> value(v, second);
    }

    default public LongFilter setFirst(long first) {
        return v -> value(first, v);
    }
}
