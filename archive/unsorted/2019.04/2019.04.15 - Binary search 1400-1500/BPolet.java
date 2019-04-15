package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class BPolet {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        a = in.nextIntArray(n);
        b = in.nextIntArray(n);

        double curZ = 0.0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = n-1; i > 0; i--) {
            deque.addLast(a[i]);
            deque.addLast(b[i]);
        }
        deque.addFirst(b[0]);
        deque.addLast(a[0]);

        for (int val : deque) {
            curZ += (curZ + m)/(val - 1);
        }

        if(curZ == Double.POSITIVE_INFINITY) out.noAns();
        else out.printLine(curZ);
    }

}