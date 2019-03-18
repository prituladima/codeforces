package com.prituladima.yaal.generated.collections.comparator;

/**
 *
 */
public interface DoubleComparator {
    public static final DoubleComparator DEFAULT = (first, second) -> {
        if (first < second) {
            return -1;
        }
        if (first > second) {
            return 1;
        }
        return 0;
    };

    public static final DoubleComparator REVERSE = (first, second) -> {
        if (first > second) {
            return -1;
        }
        if (first < second) {
            return 1;
        }
        return 0;
    };

    public int compare(double first, double second);
}
