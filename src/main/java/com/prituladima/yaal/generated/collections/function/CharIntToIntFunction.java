package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface CharIntToIntFunction {
    public int value(char first, int second);

    default public CharToIntFunction setSecond(int second) {
        return v -> value(v, second);
    }

    default public IntToIntFunction setFirst(char first) {
        return v -> value(first, v);
    }
}
