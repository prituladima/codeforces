package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface CharCharToLongFunction {
    public long value(char first, char second);

    default public CharToLongFunction setSecond(char second) {
        return v -> value(v, second);
    }

    default public CharToLongFunction setFirst(char first) {
        return v -> value(first, v);
    }
}
