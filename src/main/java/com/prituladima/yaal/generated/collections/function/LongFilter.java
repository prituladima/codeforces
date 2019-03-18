package com.prituladima.yaal.generated.collections.function;

/**
 *
 */
public interface LongFilter {
    public boolean accept(long value);

    default public LongFilter or(LongFilter f) {
        return (val) -> LongFilter.this.accept(val) || f.accept(val);
    }

    default public LongFilter and(LongFilter f) {
        return (val) -> LongFilter.this.accept(val) && f.accept(val);
    }

    default public LongFilter xor(LongFilter f) {
        return (val) -> LongFilter.this.accept(val) ^ f.accept(val);
    }

    default public LongFilter not() {
        return (val) -> !LongFilter.this.accept(val);
    }
}
