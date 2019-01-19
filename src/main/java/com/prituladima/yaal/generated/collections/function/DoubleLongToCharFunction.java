package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface DoubleLongToCharFunction {
    public char value(double first, long second);

    default public DoubleToCharFunction setSecond(long second) {
        return v -> value(v, second);
    }

    default public LongToCharFunction setFirst(double first) {
        return v -> value(first, v);
    }
}
