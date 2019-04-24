package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class ANekoIVinograd {
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
        b = in.nextIntArray(m);

        int ea = 0;
        int eb = 0;
        for (int i = 0; i < n; i++) {
            ea += a[i] % 2 == 0 ? 1 : 0;
        }
        for (int i = 0; i < m; i++) {
            eb += b[i] % 2 == 0 ? 1 : 0;
        }
        int oa = n - ea;
        int ob = m - eb;

        out.printLine(Math.min(ea, ob)+Math.min(oa, eb));



    }

}