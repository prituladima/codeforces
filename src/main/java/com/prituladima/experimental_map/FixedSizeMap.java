package com.prituladima.experimental_map;

import androidx.collection.ArrayMap;

import java.lang.reflect.Array;
import java.util.*;

// TODO: 30.05.2020 key null support
// TODO: 30.05.2020 jmh
// TODO: 30.05.2020 separated methods for null keys
public class FixedSizeMap<K, V> implements Map<K, V> {

    int capacity;
    private Object[] keys;
    private Object[] vals;

    public FixedSizeMap(int capacity) {
        this.capacity = capacity;
        this.keys = new Object[capacity];
        this.vals = new Object[capacity];
    }


    /**
     * Map implementation
     */
    private boolean isData(Object key, Object val) {
        return key != null || val != null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < capacity; i++) {
            if (isData(keys[i], vals[i])) {
                size++;
            }
        }

        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (int i = 0; i < capacity; i++) {
            if (isData(keys[i], vals[i]) && Objects.equals(keys[i], key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < capacity; i++) {
            if (isData(keys[i], vals[i]) && Objects.equals(vals[i], value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for (int i = 0; i < capacity; i++) {
            if (isData(keys[i], vals[i]) && Objects.equals(keys[i], key)) {
                return (V) vals[i];
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (containsKey(key)) {
            return update(key, value);
        } else {
            return insert(key, value);
        }
    }

    private V update(K key, V value) {
        for (int i = 0; i < capacity; i++) {
            if (isData(keys[i], vals[i]) && Objects.equals(keys[i], key)) {
                return (V) (vals[i] = value);
            }
        }
        throw new RuntimeException();
    }


    private V insert(K key, V value) {
        for (int i = 0; i < capacity; i++) {
            if (!isData(keys[i], vals[i])) {
                keys[i] = key;
                return (V) (vals[i] = value);
            }
        }
        throw new RuntimeException();
    }


    @Override
    public V remove(Object key) {
        if (!containsKey(key)) {
            return null;
        }

        V result;
        for (int i = 0; i < capacity; i++) {
            if (isData(keys[i], vals[i]) && Objects.equals(keys[i], key)) {
                keys[i] = null;
                result = (V) vals[i];
                vals[i] = null;
                return result;
            }
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
        Arrays.fill(keys, null);
        Arrays.fill(vals, null);
    }

    @Override
    public Set<K> keySet() {
        List<K> ans = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (isData(keys[i], vals[i])) {
                ans.add((K) keys[i]);
            }
        }
        return new HashSet<>(ans);
    }

    @Override
    public Collection<V> values() {
        Collection<V> ans = new ArrayList<>(3);
        for (int i = 0; i < capacity; i++) {
            if (isData(keys[i], vals[i])) {
                ans.add((V) vals[i]);
            }
        }
        return ans;
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> result = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            if (isData(keys[i], vals[i]))
                result.add(new AbstractMap.SimpleEntry<>((K) keys[i], (V) vals[i]));
        }
        return result;
    }
}