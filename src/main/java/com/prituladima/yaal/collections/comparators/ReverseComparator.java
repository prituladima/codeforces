package com.prituladima.yaal.collections.comparators;

import java.util.Comparator;

public class ReverseComparator<T extends Comparable<T>> implements Comparator<T> {
    public int compare(T o1, T o2) {
        return o2.compareTo(o1);
    }
}
