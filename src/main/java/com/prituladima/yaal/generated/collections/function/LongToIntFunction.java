package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface LongToIntFunction {
    public int value(long key);

    default public DoubleToIntFunction combine(DoubleToLongFunction f) {
        return val -> value(f.value(val));
    }

    default public IntToIntFunction combine(IntToLongFunction f) {
        return val -> value(f.value(val));
    }

    default public LongToIntFunction combine(LongToLongFunction f) {
        return val -> value(f.value(val));
    }

    default public CharToIntFunction combine(CharToLongFunction f) {
        return val -> value(f.value(val));
    }
}
