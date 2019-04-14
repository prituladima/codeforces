package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IKDominiruyushiiSimvol {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        s = in.nextToken().toCharArray();
        n = s.length;
        ans = INF;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(s[i]);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (!set.contains(c)) continue;
            int curMax = 0;
            int distance = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] == c) {
                    curMax = Math.max(curMax, distance);
                    distance = 0;
                } else {
                    distance++;
                }

                if (i == n - 1 && distance != 0) {
                    curMax = Math.max(curMax, distance);
                    distance = 0;
                }
            }
//            if(curMax != 0)
            ans = Math.min(1+curMax, ans);
        }

        out.printLine(ans);

    }

}