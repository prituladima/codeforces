package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class EObmenSosednihElementov {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b, maxPrefix, minSuffix;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes".toUpperCase(), NO = "No".toUpperCase();
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        a = in.nextIntArray(n);
        s = in.nextToken().toCharArray();
        maxPrefix = new int[n];
        minSuffix = new int[n];
        maxPrefix[0] = a[0];
        for (int i = 1; i < n; i++) {
            maxPrefix[i] = Math.max(a[i], maxPrefix[i - 1]);
        }
        minSuffix[n-1] = a[n-1];
        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = Math.min(a[i], minSuffix[i + 1]);
        }


        for (int i = 1; i < n; i++) {
            if (s[i - 1] == '0' && maxPrefix[i-1]> minSuffix[i]) {
                out.printLine(NO);
                return;
            }
        }
        out.printLine(YES);
    }
}