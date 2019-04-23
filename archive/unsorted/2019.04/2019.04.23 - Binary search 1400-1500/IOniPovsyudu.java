package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IOniPovsyudu {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;
    int uniq;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        s = in.nextToken().toCharArray();
        uniq = GeekInteger.uniq(s).length;

        int ansK = n;
        int L = 0;
        int R = n;
        while (L <= R) {
            int M = (L + R) >>> 1;
            if (solutionExist(M)) {
                ansK = M;
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        out.printLine(ansK);
    }

    private boolean solutionExist(int k) {
        Map<Character, Integer> ms = new HashMap<>();
        for (int i = 0; i < k; i++) {
            ms.merge(s[i], 1, Integer::sum);
        }
        if (ms.size() == uniq) return true;

        for (int i = k; i < n; i++) {
            ms.merge(s[i], 1, Integer::sum);
            int toRem = i - k;
            if (ms.get(s[toRem]) == 1) {
                ms.remove(s[toRem]);
            } else {
                ms.merge(s[toRem], -1, Integer::sum);
            }
            if (ms.size() == uniq) return true;
        }

        return false;
    }

}