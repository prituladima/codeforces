package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class AArbitrazhAkcii {
    int t, n, r, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
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
        r = in.nextInt();

        a = in.nextIntArray(n);
        b = in.nextIntArray(m);

        int minA = Integer.MAX_VALUE;
        int maxB = Integer.MIN_VALUE;

        for (int i : a) minA = Math.min(minA, i);
        for (int i : b) maxB = Math.max(maxB, i);

        if(minA >= maxB){
            out.printLine(r);
            return;
        }

        int rdiv = r / minA;
        int rmod = r % minA;
        out.printLine(rdiv*maxB + rmod);

    }

}