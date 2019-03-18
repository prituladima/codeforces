package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface IntIntToCharFunction {
    public char value(int first, int second);

    default public IntToCharFunction setSecond(int second) {
        return v -> value(v, second);
    }

    default public IntToCharFunction setFirst(int first) {
        return v -> value(first, v);
    }
}
