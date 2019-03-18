package com.prituladima.yaal.collections.map;

import com.prituladima.yaal.misc.Factory;

/**
 *
 */
public class CPPMap<K, V> extends EHashMap<K, V> {
    private final Factory<V> defaultValueFactory;

    public CPPMap(Factory<V> defaultValueFactory) {
        this.defaultValueFactory = defaultValueFactory;
    }

    @Override
    public V get(Object key) {
        if (containsKey(key)) {
            return super.get(key);
        }
        V value = defaultValueFactory.create();
        try {
            //noinspection unchecked
            super.put((K) key, value);
            return value;
        } catch (ClassCastException e) {
            return value;
        }
    }
}
