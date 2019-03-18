package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface CharLongPredicate {
    public boolean value(char first, long second);

    default public CharFilter setSecond(long second) {
        return v -> value(v, second);
    }

    default public LongFilter setFirst(char first) {
        return v -> value(first, v);
    }
}
