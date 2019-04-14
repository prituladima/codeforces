package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;
import com.prituladima.yaal.numbers.IntegerUtils;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class MArpaIEkzamenPoGeometrii {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        pairs = in.nextIntPairArray(3);
        if(triangle_area_2(pairs[0].first, pairs[0].second, pairs[1].first, pairs[1].second, pairs[2].first, pairs[2].second) == 0
                || dist(pairs[0].first, pairs[0].second, pairs[1].first, pairs[1].second) != dist(pairs[1].first, pairs[1].second, pairs[2].first, pairs[2].second)) {
            out.printLine(NO);
        }else {
            out.printLine(YES);
        }
    }

    long triangle_area_2 (int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x2 - x1) *(long) (y3 - y1) - (y2 - y1) * (long)(x3 - x1);
    }

    long dist(int ax, int ay, int bx, int by){
        return IntegerUtils.power(Math.abs((long) ax - bx), 2) +
         IntegerUtils.power(Math.abs((long) ay - by), 2);
    }

}