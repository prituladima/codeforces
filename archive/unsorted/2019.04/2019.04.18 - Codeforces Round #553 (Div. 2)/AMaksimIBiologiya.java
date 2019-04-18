package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class AMaksimIBiologiya {
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
        s = in.nextToken().toCharArray();

        ans = INF;
        for (int i = 0; i < n - 3; i++) {
            int cur = 0;
            cur += dist(s[i], 'A');
            cur += dist(s[i + 1], 'C');
            cur += dist(s[i + 2], 'T');
            cur += dist(s[i + 3], 'G');
            ans = Math.min(ans, cur);
        }
        out.printLine(ans);

    }

    private int dist(char a, char b) {
        int aa = Math.min(a, b);
        int bb = Math.max(a, b);
        return Math.min(bb - aa, (aa - 'A') + ('Z' - bb) + 1);
    }


}