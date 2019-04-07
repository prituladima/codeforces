package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class ELenta {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] b, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        b = in.nextIntArray(n);

        int[] diff = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            diff[i] = b[i + 1] - b[i] - 1;
        }
        GeekInteger.save_sort(diff);

        ans = n;
        for (int i = 0; i < n - k ; i++) {
            ans += diff[i];
        }

        out.printLine(ans);


    }

}