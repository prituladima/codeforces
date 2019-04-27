package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class QHalyavaLeti {
    int T, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] t, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        t = in.nextIntArray(n);
        T = in.nextInt();
        int[] k = new int[1001];
        for (int i = 0; i < t.length; i++) {
            k[t[i]]++;
        }

        int ans = -INF;
        int curAns = 0;

        for (int i = 1; i <= T; i++) {
            curAns += k[i];
        }

        ans = Math.max(ans, curAns);

        for (int i = T + 1; i <= 1000; i++) {
            int j = i - T - 1;
            curAns -= k[j];
            curAns += k[i];
            ans = Math.max(ans, curAns);
        }

        out.printLine(ans);
    }

}