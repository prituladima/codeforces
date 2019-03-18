package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface IntFilter {
    public boolean accept(int value);

    default public IntFilter or(IntFilter f) {
        return (val) -> IntFilter.this.accept(val) || f.accept(val);
    }

    default public IntFilter and(IntFilter f) {
        return (val) -> IntFilter.this.accept(val) && f.accept(val);
    }

    default public IntFilter xor(IntFilter f) {
        return (val) -> IntFilter.this.accept(val) ^ f.accept(val);
    }

    default public IntFilter not() {
        return (val) -> !IntFilter.this.accept(val);
    }
}
