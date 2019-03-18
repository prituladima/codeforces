package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface LongDoubleToIntFunction {
    public int value(long first, double second);

    default public LongToIntFunction setSecond(double second) {
        return v -> value(v, second);
    }

    default public DoubleToIntFunction setFirst(long first) {
        return v -> value(first, v);
    }
}
