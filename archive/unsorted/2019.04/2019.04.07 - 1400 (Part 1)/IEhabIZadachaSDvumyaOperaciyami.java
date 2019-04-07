package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class IEhabIZadachaSDvumyaOperaciyami {
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
        int n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        out.printLine(n + 1);
        for (int i = n; i >= 1; i--) {
            int x = (i - a[i]) % (n + 1);
            if (x < 0) x += (n + 1);
            out.printFormat("1 %d %d\n", i, x);
            for (int j = 1; j < i; j++) {
                a[j] += x;
            }
        }
        out.printFormat("2 %d %d\n", n, n + 1);

    }
}