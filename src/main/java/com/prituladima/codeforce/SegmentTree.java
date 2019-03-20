package com.prituladima.codeforce;

import java.util.function.BiFunction;

public interface SegmentTree<T> {

    default void update(int from, int upTo, T value) {
        update(1, from, upTo, value, (oldValue, newValue) -> newValue);
    }

    default void update(int index, T value) {
        update(1, index, value, (oldValue, newValue) -> newValue);
    }

    void build (int array[], int cur, int left, int right);

    void update(int cur, int from, int upTo, T value, BiFunction<? super T, ? super T, ? extends T> remappingFunction);

    void update(int cur, int index, T value, BiFunction<? super T, ? super T, ? extends T> remappingFunction);

}