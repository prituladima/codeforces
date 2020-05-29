package com.prituladima.codeforce;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BiMap<K, V> implements Map<K, V> {

    private K key1, key2;
    private V val1, val2;


    @Override
    public int size() {
        int size = 0;
        if (key1 != null) size++;
        if (key2 != null) size++;
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        Objects.requireNonNull(key);

        if (key1 == key) return true;
        if (key2 == key) return true;
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if (val1 == value) return true;
        if (val2 == value) return true;
        return false;
    }

    @Override
    public V get(Object key) {
        Objects.requireNonNull(key);

        if (key1 == key) return val1;
        if (key2 == key) return val2;
        return null;
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);
        if (key1 == key) return val1 = value;
        if (key2 == key) return val2 = value;
        if (key1 == null) {
            key1 = key;
            return val1 = value;
        }
        if (key2 == null) {
            key2 = key;
            return val1 = value;
        }

        throw new RuntimeException();
    }

    @Override
    public V remove(Object key) {
        Objects.requireNonNull(key);
        V result;
        if (key1 == key) {
            key1 = null;
            result = val1;
            val1 = null;
            return result;
        }
        if (key2 == key) {
            key2 = null;
            result = val2;
            val2 = null;
            return result;
        }

        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (K k : m.keySet()) {
            put(k, m.get(k));
        }
    }

    @Override
    public void clear() {
        key1 = null;
        key2 = null;
        val1 = null;
        val2 = null;
    }

    @Override
    public Set<K> keySet() {
        return new HashSet<>(Arrays.asList(key1, key2));
    }

    @Override
    public Collection<V> values() {
        return Arrays.asList(val1, val2);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new HashSet<>(Arrays.asList(
                new AbstractMap.SimpleEntry(key1, val1),
                new AbstractMap.SimpleEntry(key2, val2)
        ));
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        Objects.requireNonNull(key);

        return null;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {

    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {

    }

    @Override
    public V putIfAbsent(K key, V value) {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        return false;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return false;
    }

    @Override
    public V replace(K key, V value) {
        return null;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return null;
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return null;
    }


}
