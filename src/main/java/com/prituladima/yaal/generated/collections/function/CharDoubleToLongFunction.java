package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface CharDoubleToLongFunction {
    public long value(char first, double second);

    default public CharToLongFunction setSecond(double second) {
        return v -> value(v, second);
    }

    default public DoubleToLongFunction setFirst(char first) {
        return v -> value(first, v);
    }
}
