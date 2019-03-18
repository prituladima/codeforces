package com.prituladima.yaal.collections.map;

/**
 *
 */
public class Indexer<K> extends EHashMap<K, Integer> {
    private int index = 0;

    @Override
    public Integer get(Object key) {
        if (!containsKey(key)) {
            put((K) key, index++);
        }
        return super.get(key);
    }
}
