package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface IntIntPredicate {
    public boolean value(int first, int second);

    default public IntFilter setSecond(int second) {
        return v -> value(v, second);
    }

    default public IntFilter setFirst(int first) {
        return v -> value(first, v);
    }
}
