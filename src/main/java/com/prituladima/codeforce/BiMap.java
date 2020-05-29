package com.prituladima.codeforce;

import java.util.*;

public class BiMap<K, V> implements Map<K, V> {

    private K key1, key2, key3;
    private V val1, val2, val3;

    @Override
    public int size() {
        int size = 0;
        if (key1 != null) size++;
        if (key2 != null) size++;
        if (key3 != null) size++;
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        Objects.requireNonNull(key);

        if (Objects.equals(key1, key)) return true;
        if (Objects.equals(key2, key)) return true;
        if (Objects.equals(key3, key)) return true;

        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Objects.requireNonNull(value);

        if (Objects.equals(val1, value)) return true;
        if (Objects.equals(val2, value)) return true;
        if (Objects.equals(val3, value)) return true;

        return false;
    }

    @Override
    public V get(Object key) {
        Objects.requireNonNull(key);

        if (Objects.equals(key1, key)) return val1;
        if (Objects.equals(key2, key)) return val2;
        if (Objects.equals(key3, key)) return val3;

        return null;
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);

        if (Objects.equals(key1, key)) return val1 = value;
        if (Objects.equals(key2, key)) return val2 = value;
        if (Objects.equals(key3, key)) return val3 = value;


        if (key1 == null) {
            key1 = key;
            return val1 = value;
        }
        if (key2 == null) {
            key2 = key;
            return val2 = value;
        }
        if (key3 == null) {
            key3 = key;
            return val3 = value;
        }

        throw new RuntimeException();
    }

    @Override
    public V remove(Object key) {
        Objects.requireNonNull(key);

        V result;
        if (Objects.equals(key1, key)) {
            key1 = null;
            result = val1;
            val1 = null;
            return result;
        }
        if (Objects.equals(key2, key)) {
            key2 = null;
            result = val2;
            val2 = null;
            return result;
        }
        if (Objects.equals(key3, key)) {
            key3 = null;
            result = val3;
            val3 = null;
            return result;
        }

        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Objects.requireNonNull(m);
        for (K k : m.keySet()) {
            put(k, m.get(k));
        }
    }

    @Override
    public void clear() {
        key1 = null;
        val1 = null;

        key2 = null;
        val2 = null;

        key3 = null;
        val3 = null;
    }

    @Override
    public Set<K> keySet() {
        return new HashSet<>(Arrays.asList(key1, key2, key3));
    }

    @Override
    public Collection<V> values() {
        return Arrays.asList(val1, val2, val3);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> result = new HashSet<>();
        result.add(new AbstractMap.SimpleEntry(key1, val1));
        result.add(new AbstractMap.SimpleEntry(key2, val2));
        result.add(new AbstractMap.SimpleEntry(key3, val3));
        return result;
    }
}