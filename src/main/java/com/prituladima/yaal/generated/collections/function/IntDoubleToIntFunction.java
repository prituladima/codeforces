package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface IntDoubleToIntFunction {
    public int value(int first, double second);

    default public IntToIntFunction setSecond(double second) {
        return v -> value(v, second);
    }

    default public DoubleToIntFunction setFirst(int first) {
        return v -> value(first, v);
    }
}
