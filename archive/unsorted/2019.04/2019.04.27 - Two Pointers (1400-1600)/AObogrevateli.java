package com.prituladima.codeforce;

import com.prituladima.yaal.ds.MinSegmentTree;
import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class AObogrevateli {
    int t, n, m, k, ans = 0, r, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        r = in.nextInt();
        a = in.nextIntArray(n);
        int ans = 0;
        int[] amountOfUsefull = new int[n];
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) {
                for (int j = Math.max(0, (i - r + 1)); j <= Math.min(n - 1, i + r - 1); j++) {
                    amountOfUsefull[j]++;
                }
                ans++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (amountOfUsefull[i] == 0) {
                out.printNoAns();
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) {
                boolean ok = false;
                for (int j = Math.max(0, (i - r + 1)); j <= Math.min(n - 1, i + r - 1); j++) {
                    if (amountOfUsefull[j] == 1)
                        ok = true;
                }
                if (!ok) {
                    ans--;
                    for (int j = Math.max(0, (i - r + 1)); j <= Math.min(n - 1, i + r - 1); j++) {
                        amountOfUsefull[j]--;
                    }
                }
            }
        }

        out.printLine(ans);
    }

}