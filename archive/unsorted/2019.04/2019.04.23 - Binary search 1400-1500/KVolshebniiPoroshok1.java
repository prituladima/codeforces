package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KVolshebniiPoroshok1 {
    long t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    long[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    private boolean can(long amount) {
        long localK = k;
        for (int i = 0; i < n; i++) {
//            b[i]/a[i]->amount
            long need = Math.max(0L, amount * a[i] - b[i]);
            if (need > localK) {
                return false;
            }
            localK -= need;
        }
        return true;
    }


    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextLong();
        k = in.nextLong();
        a = in.nextLongArray((int)n);
        b = in.nextLongArray((int)n);

        long ansAmount = 0;
        long L = 0;
        long R = (int) 2e9 + 10;
        while (L <= R) {
            long M = (L + R) >>> 1;
            if (can(M)) {
                ansAmount = M;
                L = M + 1;
            } else {
                R = M - 1;
            }
        }

        out.printLine(ansAmount);


    }

}