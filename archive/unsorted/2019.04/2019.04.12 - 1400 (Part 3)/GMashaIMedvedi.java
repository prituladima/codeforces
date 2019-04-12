package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class GMashaIMedvedi {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int V1 = in.nextInt();
        int V2 = in.nextInt();
        int V3 = in.nextInt();
        int Vm = in.nextInt();

        for (int i = 1; i <= 200; i++) {
            for (int j = 1; j <= 200; j++) {
                for (int k = 1; k <= 200; k++) {
                    boolean ok = i > j && j > k;
                    ok &= i >= V1;
                    ok &= 2 * V1 >= i;
                    ok &= j >= V2;
                    ok &= 2 * V2 >= j;
                    ok &= k >= V3;
                    ok &= 2 * V3 >= k;
                    ok &= k >= Vm;
                    ok &= 2 * Vm >= k;
                    ok &= 2 * Vm < j;
                    ok &= 2 * Vm < i;


                    if (ok) {

                        out.printFormat("%d\n%d\n%d\n", i, j, k);
                        return;
                    }
                }
            }

        }


        out.printNoAns();
    }

}