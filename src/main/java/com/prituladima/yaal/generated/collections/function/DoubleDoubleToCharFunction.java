package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface DoubleDoubleToCharFunction {
    public char value(double first, double second);

    default public DoubleToCharFunction setSecond(double second) {
        return v -> value(v, second);
    }

    default public DoubleToCharFunction setFirst(double first) {
        return v -> value(first, v);
    }
}
