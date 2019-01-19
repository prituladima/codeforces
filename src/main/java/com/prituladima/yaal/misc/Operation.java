package com.prituladima.yaal.misc;

/**
 *  */
public interface Operation<V> extends Factory<V> {
    public V operation(V first, V second);
}
