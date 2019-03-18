package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface DoubleFilter {
    public boolean accept(double value);

    default public DoubleFilter or(DoubleFilter f) {
        return (val) -> DoubleFilter.this.accept(val) || f.accept(val);
    }

    default public DoubleFilter and(DoubleFilter f) {
        return (val) -> DoubleFilter.this.accept(val) && f.accept(val);
    }

    default public DoubleFilter xor(DoubleFilter f) {
        return (val) -> DoubleFilter.this.accept(val) ^ f.accept(val);
    }

    default public DoubleFilter not() {
        return (val) -> !DoubleFilter.this.accept(val);
    }
}
