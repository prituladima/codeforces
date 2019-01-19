package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface CharIntToLongFunction {
    public long value(char first, int second);

    default public CharToLongFunction setSecond(int second) {
        return v -> value(v, second);
    }

    default public IntToLongFunction setFirst(char first) {
        return v -> value(first, v);
    }
}
