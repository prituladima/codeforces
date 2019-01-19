package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface CharIntToDoubleFunction {
    public double value(char first, int second);

    default public CharToDoubleFunction setSecond(int second) {
        return v -> value(v, second);
    }

    default public IntToDoubleFunction setFirst(char first) {
        return v -> value(first, v);
    }
}
