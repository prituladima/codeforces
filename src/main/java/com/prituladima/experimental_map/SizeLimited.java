package com.prituladima.experimental_map;

import java.util.Map;

public interface SizeLimited<K, V> {

    int getMinCapacity();

    int getMaxCapacity();

    Map<K, V> getMapWithSmallerCapacity();

    Map<K, V> getMapWithBiggerCapacity();
}
