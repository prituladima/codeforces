package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface DoubleIntToIntFunction {
    public int value(double first, int second);

    default public DoubleToIntFunction setSecond(int second) {
        return v -> value(v, second);
    }

    default public IntToIntFunction setFirst(double first) {
        return v -> value(first, v);
    }
}
