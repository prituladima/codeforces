package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class JOsadaValgalli {
    int t, q, n, m, ans = 0, INF = Integer.MAX_VALUE;
    long[] a, prefA;
    long[] k;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        q = in.nextInt();
        a = in.nextLongArray(n);
        k = in.nextLongArray(q);
        prefA = GeekInteger.calculatePrefixSum(a);

        long sum = prefA[n - 1];
        long cur = 0;
        for (int i = 0; i < q; i++) {
            if (cur + k[i] >= sum) {
                out.printLine(n);
                cur = 0;
            } else {
                cur += k[i];
                out.printLine(n - GeekInteger.upperBound(prefA, prefA.length, cur));
            }
        }


    }

}