package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface DoubleLongToLongFunction {
    public long value(double first, long second);

    default public DoubleToLongFunction setSecond(long second) {
        return v -> value(v, second);
    }

    default public LongToLongFunction setFirst(double first) {
        return v -> value(first, v);
    }
}
