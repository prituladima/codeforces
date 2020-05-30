package com.prituladima.experimental_map;

import androidx.collection.ArrayMap;

import java.util.*;

// TODO: 30.05.2020 key null support
// TODO: 30.05.2020 jmh
// TODO: 30.05.2020 separated methods for null keys
public class FixedSize3Map<K, V> implements Map<K, V>, SizeLimited<K, V> {

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
    public Map<K, V> getMapWithBiggerCapacity() {
        return new ArrayMap<>(getMaxCapacity() + 1);
    }

    @Override
    public Map<K, V> getMapWithSmallerCapacity() {
        throw new RuntimeException();
    }


    /**
     * Map implementation
     */
    private boolean isDataItem(K key, V val) {
        return key != null || val != null;
    }

    @Override
    public int size() {
        int size = 0;
        if (isDataItem(key1, val1)) size++;
        if (isDataItem(key2, val2)) size++;
        if (isDataItem(key3, val3)) size++;
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (isDataItem(key1, val1) && Objects.equals(key1, key)) return true;
        if (isDataItem(key2, val2) && Objects.equals(key2, key)) return true;
        if (isDataItem(key3, val3) && Objects.equals(key3, key)) return true;
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if (isDataItem(key1, val1) && Objects.equals(val1, value)) return true;
        if (isDataItem(key2, val2) && Objects.equals(val2, value)) return true;
        if (isDataItem(key3, val3) && Objects.equals(val3, value)) return true;
        return false;
    }

    @Override
    public V get(Object key) {
        if (isDataItem(key1, val1) && Objects.equals(key1, key)) return val1;
        if (isDataItem(key2, val2) && Objects.equals(key2, key)) return val2;
        if (isDataItem(key3, val3) && Objects.equals(key3, key)) return val3;
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
        if (isDataItem(key1, val1) && Objects.equals(key1, key)) return val1 = value;
        if (isDataItem(key2, val2) && Objects.equals(key2, key)) return val2 = value;
        if (isDataItem(key3, val3) && Objects.equals(key3, key)) return val3 = value;
        throw new RuntimeException();
    }


    private V insert(K key, V value) {
        if (!isDataItem(key1, val1)) {
            key1 = key;
            return val1 = value;
        }
        if (!isDataItem(key2, val2)) {
            key2 = key;
            return val2 = value;
        }
        if (!isDataItem(key3, val3)) {
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

        V result;
        if (isDataItem(key1, val1) && Objects.equals(key1, key)) {
            key1 = null;
            result = val1;
            val1 = null;
            return result;
        }
        if (isDataItem(key2, val2) && Objects.equals(key2, key)) {
            key2 = null;
            result = val2;
            val2 = null;
            return result;
        }
        if (isDataItem(key3, val3) && Objects.equals(key3, key)) {
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
        List<K> ans = new ArrayList<>(3);
        if (isDataItem(key1, val1)) ans.add(key1);
        if (isDataItem(key2, val2)) ans.add(key2);
        if (isDataItem(key3, val3)) ans.add(key3);
        return new HashSet<>(ans);
    }

    @Override
    public Collection<V> values() {
        Collection<V> ans = new ArrayList<>(3);
        if (isDataItem(key1, val1)) ans.add(val1);
        if (isDataItem(key2, val2)) ans.add(val2);
        if (isDataItem(key3, val3)) ans.add(val3);
        return ans;
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> result = new HashSet<>();
        if (isDataItem(key1, val1))
            result.add(new AbstractMap.SimpleEntry<>(key1, val1));
        if (isDataItem(key2, val2))
            result.add(new AbstractMap.SimpleEntry<>(key2, val2));
        if (isDataItem(key3, val3))
            result.add(new AbstractMap.SimpleEntry<>(key3, val3));
        return result;
    }
}