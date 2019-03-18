package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface IntLongPredicate {
    public boolean value(int first, long second);

    default public IntFilter setSecond(long second) {
        return v -> value(v, second);
    }

    default public LongFilter setFirst(int first) {
        return v -> value(first, v);
    }
}
