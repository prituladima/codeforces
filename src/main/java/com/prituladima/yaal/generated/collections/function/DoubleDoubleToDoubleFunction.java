package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface DoubleDoubleToDoubleFunction {
    public double value(double first, double second);

    default public DoubleToDoubleFunction setSecond(double second) {
        return v -> value(v, second);
    }

    default public DoubleToDoubleFunction setFirst(double first) {
        return v -> value(first, v);
    }
}
