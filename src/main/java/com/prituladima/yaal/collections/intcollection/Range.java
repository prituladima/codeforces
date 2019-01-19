package com.prituladima.yaal.collections.intcollection;

import com.prituladima.yaal.generated.collections.list.IntArray;
import com.prituladima.yaal.generated.collections.list.IntList;

/**
 *  */
public class Range {
    public static IntList range(int from, int to) {
        int[] result = new int[Math.abs(from - to)];
        int current = from;
        if (from <= to) {
            for (int i = 0; i < result.length; i++) {
                result[i] = current++;
            }
        } else {
            for (int i = 0; i < result.length; i++) {
                result[i] = current--;
            }
        }
        return new IntArray(result);
    }

    public static IntList range(int n) {
        return range(0, n);
    }
}
