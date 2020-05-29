package com.prituladima.codeforce;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class UnnamedMap<KeyType, ValueType> implements Map<KeyType, ValueType> {

    Map<KeyType, ValueType> internal;
    int size;

    public UnnamedMap() {
        size = 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public ValueType get(Object key) {
        return null;
    }

    @Override
    public ValueType put(Object key, Object value) {
        return null;
    }

    @Override
    public ValueType remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set entrySet() {
        return null;
    }





}
