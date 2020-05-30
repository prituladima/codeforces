package com.prituladima.experimental_map;

import androidx.collection.ArrayMap;

import java.util.*;

// TODO: 30.05.2020 key null support
// TODO: 30.05.2020 jmh
// TODO: 30.05.2020 separated methods for null keys
public class TripleMap<K, V> implements Map<K, V>, SizeLimited<K, V> {

    private K key1, key2, key3;
    private V val1, val2, val3;

    @Override
    public int getMinCapacity() {
        return 0;
    }

    @Override
    public int getMaxCapacity() {
        return 3;
    }

    @Override
    public Map<K, V> next() {
        return new ArrayMap<K, V>(getMaxCapacity() + 1);
    }

    @Override
    public Map<K, V> prev() {
        return null;
    }


    /**
     * Map implementation
     */
    @Override
    public int size() {
        int size = 0;
        if (key1 != null || val1 != null) size++;
        if (key2 != null || val2 != null) size++;
        if (key3 != null || val3 != null) size++;
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) {
            return containsNullKey();
        }

        if (Objects.equals(key1, key)) return true;
        if (Objects.equals(key2, key)) return true;
        if (Objects.equals(key3, key)) return true;

        return false;
    }

    private boolean containsNullKey() {
        if (key1 == null || val1 != null) return true;
        if (key2 == null || val2 != null) return true;
        if (key3 == null || val3 != null) return true;
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            return containsNullValue();
        }

        if (Objects.equals(val1, value)) return true;
        if (Objects.equals(val2, value)) return true;
        if (Objects.equals(val3, value)) return true;

        return false;
    }

    private boolean containsNullValue() {
        if (key1 != null || val1 == null) return true;
        if (key2 != null || val2 == null) return true;
        if (key3 != null || val3 == null) return true;
        return false;
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            return getByNullKey();
        }

        if (Objects.equals(key1, key)) return val1;
        if (Objects.equals(key2, key)) return val2;
        if (Objects.equals(key3, key)) return val3;

        return null;
    }

    private V getByNullKey() {
        if (key1 == null || val1 != null) return val1;
        if (key2 == null || val2 != null) return val2;
        if (key3 == null || val3 != null) return val3;
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
        if (key == null) {
            return updateByNullKey(value);
        }
        if (Objects.equals(key1, key)) return val1 = value;
        if (Objects.equals(key2, key)) return val2 = value;
        if (Objects.equals(key3, key)) return val3 = value;
        throw new RuntimeException();
    }

    private V updateByNullKey(V value) {
        if (key1 == null && val1 != null) {
            return val1 = value;
        }
        if (key2 == null && val2 != null) {
            return val2 = value;
        }
        if (key3 == null && val3 != null) {
            return val3 = value;
        }
        throw new RuntimeException();
    }


    private V insert(K key, V value) {
        if (key1 == null && val1 == null) {
            key1 = key;
            return val1 = value;
        }
        if (key2 == null && val2 == null) {
            key2 = key;
            return val2 = value;
        }
        if (key3 == null && val3 == null) {
            key3 = key;
            return val3 = value;
        }
        throw new RuntimeException();
    }


    @Override
    public V remove(Object key) {
        if (!containsKey(key)) {
            return null;
        }
        if(key == null){
            return removeByNullKey();
        }
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

    private V removeByNullKey() {
        V result = get(null);
        if(key1 == null && val1 != null){
            val1 = null;
        }
        if(key2 == null && val2 != null){
            val2 = null;
        }
        if(key3 == null && val3 != null){
            val3 = null;
        }
        return result;
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
        return new HashSet<>(Arrays.asList(
                key1,
                key2,
                key3
        ));
    }

    @Override
    public Collection<V> values() {
        return Arrays.asList(
                val1,
                val2,
                val3
        );
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> result = new HashSet<>();
        result.add(new AbstractMap.SimpleEntry<>(key1, val1));
        result.add(new AbstractMap.SimpleEntry<>(key2, val2));
        result.add(new AbstractMap.SimpleEntry<>(key3, val3));
        return result;
    }
}