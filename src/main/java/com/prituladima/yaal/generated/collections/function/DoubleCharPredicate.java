package com.prituladima.yaal.generated.collections.function;

/**
 *  */
public interface DoubleCharPredicate {
    public boolean value(double first, char second);

    default public DoubleFilter setSecond(char second) {
        return v -> value(v, second);
    }

    default public CharFilter setFirst(double first) {
        return v -> value(first, v);
    }
}
