package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface LongIntToIntFunction {
    public int value(long first, int second);

    default public LongToIntFunction setSecond(int second) {
        return v -> value(v, second);
    }

    default public IntToIntFunction setFirst(long first) {
        return v -> value(first, v);
    }
}
