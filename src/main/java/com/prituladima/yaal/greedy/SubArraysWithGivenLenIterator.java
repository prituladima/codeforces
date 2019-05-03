package com.prituladima.yaal.greedy;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SubArraysWithGivenLenIterator {
    private final int[] a;
    private final int n;
    private final int len;
    private final List<Tuple<Integer, Integer, Long>> result;
    private final boolean isCycled;

    public SubArraysWithGivenLenIterator(int[] a, int len, boolean isCycled) {
        this.a = a;
        this.n = a.length;
        this.len = len;
        this.result = new ArrayList<>();
        this.isCycled = isCycled;
        calculate();
    }

    private void calculate() {
        long curSum = 0;
        for (int i = n - 1; i >= n - len; i--) {
            curSum += a[i];
        }
        result.add(new Tuple<>(n - len, n - 1, curSum));
        for (int i = n - len - 1; i >= 0; i--) {
            curSum -= a[i + len];
            curSum += a[i];
            result.add(new Tuple<>(i, i + len - 1, curSum));
        }

        if (isCycled) {
            for (int i = n - 1; i >= n - len; i--) {
                curSum -= a[(i + len) % n];
                curSum += a[i];
                result.add(new Tuple<>(i, i + len - 1, curSum));
            }
        }
    }

    public Stream<Tuple<Integer, Integer, Long>> stream() {
        return result.stream();
    }

}
