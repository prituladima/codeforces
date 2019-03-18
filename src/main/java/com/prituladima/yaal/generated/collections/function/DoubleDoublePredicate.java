package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface DoubleDoublePredicate {
    public boolean value(double first, double second);

    default public DoubleFilter setSecond(double second) {
        return v -> value(v, second);
    }

    default public DoubleFilter setFirst(double first) {
        return v -> value(first, v);
    }
}
