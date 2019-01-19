package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface CharLongToCharFunction {
    public char value(char first, long second);

    default public CharToCharFunction setSecond(long second) {
        return v -> value(v, second);
    }

    default public LongToCharFunction setFirst(char first) {
        return v -> value(first, v);
    }
}
