package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface LongLongToLongFunction {
    public long value(long first, long second);

    default public LongToLongFunction setSecond(long second) {
        return v -> value(v, second);
    }

    default public LongToLongFunction setFirst(long first) {
        return v -> value(first, v);
    }
}
