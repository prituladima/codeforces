package com.prituladima.experimental_map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class UnnamedMap<KeyType, ValueType> implements Map<KeyType, ValueType> {

    private Map<KeyType, ValueType> internal;

    public UnnamedMap() {
        internal = new TripleMap<>();
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
        SizeLimited<KeyType, ValueType> sizeLimited = (SizeLimited<KeyType, ValueType>) internal;
        if (internal.size() == sizeLimited.getMaxCapacity()) {
            Map<KeyType, ValueType> biggerSizeMap = sizeLimited.next();
            biggerSizeMap.putAll(internal);
            internal = biggerSizeMap;
        }
    }

    @Override
    public ValueType remove(Object key) {
        optimizeCapacity();
        return internal.remove(key);
    }

    private void optimizeCapacity() {
        if (!isEmpty()) {
            SizeLimited<KeyType, ValueType> sizeLimited = (SizeLimited<KeyType, ValueType>) internal;
            if (internal.size() == sizeLimited.getMinCapacity()) {
                Map<KeyType, ValueType> smallerSizeMap = sizeLimited.prev();
                smallerSizeMap.putAll(internal);
                internal = smallerSizeMap;
            }
        }
    }

    @Override
    public void putAll(Map<? extends KeyType, ? extends ValueType> m) {
        internal.putAll(m);
    }

    @Override
    public void clear() {
        internal = new TripleMap<>();
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
