package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

import static java.util.Arrays.sort;

public class OKefaIKompaniya {
    int t, n, m, k, ans = 0, d, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;


    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        d = in.nextInt();
        pairs = in.nextIntPairArray(n);
        sort(pairs);
        long curSum = 0;
        long resSum = Long.MIN_VALUE;
        for (int i = 0, j = 0; i < n; i++) {
            while (Math.abs(pairs[i].first - pairs[j].first) >= d) {
                curSum -= pairs[j].second;
                j++;
            }
            curSum += pairs[i].second;
            resSum = Math.max(curSum, resSum);
        }
        out.printLine(resSum);
    }

}