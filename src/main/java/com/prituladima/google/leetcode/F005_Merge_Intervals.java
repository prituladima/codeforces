package com.prituladima.google.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class F005_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        List<Pair> sorted = new ArrayList<>();
        for (int[] cur : intervals) {
            sorted.add(new Pair(cur[0], cur[1]));
        }
        sorted.sort(Comparator.comparingInt(Pair::getFirst).thenComparing(Pair::getSecond, Comparator.reverseOrder()));
        Pair first = sorted.get(0);
        List<Pair> res = new ArrayList<>();
        res.add(new Pair(first.getFirst(), first.getSecond()));

        for (int i = 1; i < sorted.size(); i++) {
            final Pair last = res.get(res.size() - 1);
            final Pair current = sorted.get(i);
            if (last.getSecond() >= current.getFirst()) {
                last.setSecond(Math.max(last.getSecond(), current.getSecond()));
            } else {
                res.add(new Pair(current.getFirst(), current.getSecond()));
            }
        }

        int[][] resArr = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = new int[]{res.get(i).getFirst(), res.get(i).getSecond()};
        }
        return resArr;
    }

    private static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        int getFirst() {
            return first;
        }

        int getSecond() {
            return second;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }
}
