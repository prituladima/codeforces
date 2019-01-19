package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface DoubleIntToDoubleFunction {
    public double value(double first, int second);

    default public DoubleToDoubleFunction setSecond(int second) {
        return v -> value(v, second);
    }

    default public IntToDoubleFunction setFirst(double first) {
        return v -> value(first, v);
    }
}
