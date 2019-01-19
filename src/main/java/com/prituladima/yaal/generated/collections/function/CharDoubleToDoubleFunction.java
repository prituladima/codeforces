package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface CharDoubleToDoubleFunction {
    public double value(char first, double second);

    default public CharToDoubleFunction setSecond(double second) {
        return v -> value(v, second);
    }

    default public DoubleToDoubleFunction setFirst(char first) {
        return v -> value(first, v);
    }
}
