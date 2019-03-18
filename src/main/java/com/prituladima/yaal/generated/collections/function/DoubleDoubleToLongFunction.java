package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface DoubleDoubleToLongFunction {
    public long value(double first, double second);

    default public DoubleToLongFunction setSecond(double second) {
        return v -> value(v, second);
    }

    default public DoubleToLongFunction setFirst(double first) {
        return v -> value(first, v);
    }
}
