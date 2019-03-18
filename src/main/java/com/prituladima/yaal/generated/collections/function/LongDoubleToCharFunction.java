package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface LongDoubleToCharFunction {
    public char value(long first, double second);

    default public LongToCharFunction setSecond(double second) {
        return v -> value(v, second);
    }

    default public DoubleToCharFunction setFirst(long first) {
        return v -> value(first, v);
    }
}
