package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class AServalIAvtobus {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {


        n = in.nextInt();
        t = in.nextInt();
        ans = INF;
        int res = -1;
        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            int d = in.nextInt();
            if (s < t) {
                aa[i] = s + d*GeekInteger.ceilingDivide(t - s, d);
            } else {
                aa[i] = s;
            }
        }
        for (int i = 0; i < n; i++) {
            if (ans > aa[i]) {
                ans = aa[i];
                res = i + 1;
            }
        }
        out.printLine(res);

    }

}