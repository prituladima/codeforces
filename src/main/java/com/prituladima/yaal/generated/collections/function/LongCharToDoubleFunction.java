package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface LongCharToDoubleFunction {
    public double value(long first, char second);

    default public LongToDoubleFunction setSecond(char second) {
        return v -> value(v, second);
    }

    default public CharToDoubleFunction setFirst(long first) {
        return v -> value(first, v);
    }
}
