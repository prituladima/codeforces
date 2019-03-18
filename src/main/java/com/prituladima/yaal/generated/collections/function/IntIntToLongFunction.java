package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface IntIntToLongFunction {
    public long value(int first, int second);

    default public IntToLongFunction setSecond(int second) {
        return v -> value(v, second);
    }

    default public IntToLongFunction setFirst(int first) {
        return v -> value(first, v);
    }
}
