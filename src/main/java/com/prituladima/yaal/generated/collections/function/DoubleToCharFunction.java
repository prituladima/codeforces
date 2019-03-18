package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface DoubleToCharFunction {
    public char value(double key);

    default public DoubleToCharFunction combine(DoubleToDoubleFunction f) {
        return val -> value(f.value(val));
    }

    default public IntToCharFunction combine(IntToDoubleFunction f) {
        return val -> value(f.value(val));
    }

    default public LongToCharFunction combine(LongToDoubleFunction f) {
        return val -> value(f.value(val));
    }

    default public CharToCharFunction combine(CharToDoubleFunction f) {
        return val -> value(f.value(val));
    }
}
