package com.prituladima.experimental_map;

import java.util.Map;

public interface SizeLimited<K, V> {

    Map<K, V> getMapWithSmallerCapacity();

    Map<K, V> getMapWithBiggerCapacity();
}
