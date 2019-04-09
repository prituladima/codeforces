package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class GTriTablo {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] s, c, a, arrayAns;
    long L, R;

    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        s = in.nextIntArray(n);
        c = in.nextIntArray(n);
        ans = INF;
        for (int j = 1; j < n - 1; j++) {
            int minI = INF;
            for (int i = 0; i < j; i++) {
                if (s[i] < s[j]) {
                    minI = Math.min(minI, c[i]);
                }
            }

            int minK = INF;
            for (int k = j + 1; k < n; k++) {
                if (s[k] > s[j]) {
                    minK = Math.min(minK, c[k]);
                }
            }

            if (minI != INF && minK != INF) {
                ans = Math.min(ans, c[j] + minI + minK);
            }
        }

        if (ans == INF) {
            out.printNoAns();
        } else {
            out.printLine(ans);
        }
    }

}