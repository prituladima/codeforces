package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface LongIntToDoubleFunction {
    public double value(long first, int second);

    default public LongToDoubleFunction setSecond(int second) {
        return v -> value(v, second);
    }

    default public IntToDoubleFunction setFirst(long first) {
        return v -> value(first, v);
    }
}
