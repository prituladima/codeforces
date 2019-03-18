package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface DoubleCharToCharFunction {
    public char value(double first, char second);

    default public DoubleToCharFunction setSecond(char second) {
        return v -> value(v, second);
    }

    default public CharToCharFunction setFirst(double first) {
        return v -> value(first, v);
    }
}
