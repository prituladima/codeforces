package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class CEkleri {
    long t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextLong();
        long L = 1;
        long R = n;
        ans = R;
        while (L <= R) {
            long M = (L + R) >> 1;
            if (check(n, M)) {
                R = M - 1;
                ans = M;
            } else {
                L = M + 1;
            }
        }
        out.printLine(ans);
    }

    private boolean check(long n, long k) {
        long g = n;
        long sum = 0;
        while (n > 0) {
            sum += Math.min(k, n);
            n -= Math.min(k, n);
            n -= n / 10;
        }
        return sum*2 >= g ;
    }

}