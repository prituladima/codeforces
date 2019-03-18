package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface DoubleLongToIntFunction {
    public int value(double first, long second);

    default public DoubleToIntFunction setSecond(long second) {
        return v -> value(v, second);
    }

    default public LongToIntFunction setFirst(double first) {
        return v -> value(first, v);
    }
}
