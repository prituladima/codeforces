package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface LongDoubleToDoubleFunction {
    public double value(long first, double second);

    default public LongToDoubleFunction setSecond(double second) {
        return v -> value(v, second);
    }

    default public DoubleToDoubleFunction setFirst(long first) {
        return v -> value(first, v);
    }
}
