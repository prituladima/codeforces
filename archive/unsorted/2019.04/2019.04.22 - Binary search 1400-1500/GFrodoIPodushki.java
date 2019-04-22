package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class GFrodoIPodushki {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;
    int rem;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        rem = m - n;
        k = Math.min(k, n - k + 1);
        int ans = 0;
        int L = 0;
        int R = (int) 1e9 + 1;
        while (L <= R) {
            int mid = (L + R) >> 1;
            if (canBeAns(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        out.printLine(ans + 1);
    }

    private boolean canBeAns(int h) {
        long sum = sum(h) + sum(h - 1) - sum(Math.max(0, h - k)) - sum(Math.max(0, h - (n - k + 1)));
        return sum <= rem;
    }

    private long sum(long to) {
        return (to * (to + 1) / 2);
    }

}