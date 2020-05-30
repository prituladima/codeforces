package com.prituladima.experimental_map;

import androidx.collection.ArrayMap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class SpaceEfficientMap<KeyType, ValueType> implements Map<KeyType, ValueType> {

    private Map<KeyType, ValueType> internal;

    public SpaceEfficientMap() {
        internal = new FixedSizeMap<>(2);
    }

    @Override
    public int size() {
        return internal.size();
    }

    @Override
    public boolean isEmpty() {
        return internal.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return internal.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return internal.containsValue(value);
    }

    @Override
    public ValueType get(Object key) {
        return internal.get(key);
    }

    @Override
    public ValueType put(KeyType key, ValueType value) {
        ensureCapacity();
        return internal.put(key, value);
    }

    private void ensureCapacity() {
        if (internal.size() > 16) return;
        Map<KeyType, ValueType> biggerSizeMap;
        if (internal.size() < 16) {
            biggerSizeMap = new FixedSizeMap<>(internal.size() + 1);
        } else {
            biggerSizeMap = new ArrayMap<>();
        }
        biggerSizeMap.putAll(internal);
        internal = biggerSizeMap;
    }

    @Override
    public ValueType remove(Object key) {
        ValueType removed = internal.remove(key);
        optimizeCapacity();
        return removed;
    }

    private void optimizeCapacity() {
        if (internal.size() > 16) return;
        Map<KeyType, ValueType> smallerSizeMap;
        if (internal.size() < 16) {
            smallerSizeMap = new FixedSizeMap<>(internal.size() - 1);
        } else {
            smallerSizeMap = new ArrayMap<>();
        }
        smallerSizeMap.putAll(internal);
        internal = smallerSizeMap;
    }

    @Override
    public void putAll(Map<? extends KeyType, ? extends ValueType> m) {
        internal.putAll(m);
    }

    @Override
    public void clear() {
        internal = new FixedSizeMap<>(2);
    }

    @Override
    public Set<KeyType> keySet() {
        return internal.keySet();
    }

    @Override
    public Collection<ValueType> values() {
        return internal.values();
    }

    @Override
    public Set<Map.Entry<KeyType, ValueType>> entrySet() {
        return internal.entrySet();
    }


}
