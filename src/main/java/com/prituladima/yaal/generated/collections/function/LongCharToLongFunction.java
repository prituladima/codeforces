package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface LongCharToLongFunction {
    public long value(long first, char second);

    default public LongToLongFunction setSecond(char second) {
        return v -> value(v, second);
    }

    default public CharToLongFunction setFirst(long first) {
        return v -> value(first, v);
    }
}
