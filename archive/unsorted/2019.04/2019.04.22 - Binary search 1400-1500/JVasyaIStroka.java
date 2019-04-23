package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class JVasyaIStroka {
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
        k = in.nextInt();
        s = in.nextToken().toCharArray();

        int L = 1;
        int R = n;
        int len = L;
        while (L <= R) {
            int m = (L + R) >>> 1;
            if (fine(m)) {
                len = m;
                L = m + 1;
            } else {
                R = m - 1;
            }
        }

        out.printLine(len);
    }

    private boolean fine(int m) {
        int amountA = 0;
        int amountB = 0;
        for (int i = 0; i < m; i++) {
            amountA += s[i] == 'a' ? 1 : 0;
            amountB += s[i] == 'b' ? 1 : 0;
        }
        if (amountA <= k || amountB <= k) return true;

        for (int i = m; i < n; i++) {
            int toRem = i - m;

            amountA -= s[toRem] == 'a' ? 1 : 0;
            amountB -= s[toRem] == 'b' ? 1 : 0;

            amountA += s[i] == 'a' ? 1 : 0;
            amountB += s[i] == 'b' ? 1 : 0;
            if (amountA <= k || amountB <= k) return true;
        }

        return false;
    }

}