package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface IntLongToCharFunction {
    public char value(int first, long second);

    default public IntToCharFunction setSecond(long second) {
        return v -> value(v, second);
    }

    default public LongToCharFunction setFirst(int first) {
        return v -> value(first, v);
    }
}
