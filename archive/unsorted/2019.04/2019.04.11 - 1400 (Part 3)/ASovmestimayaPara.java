package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class ASovmestimayaPara {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    long[] a, b, arrayAns;
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
        a = in.nextLongArray(n);
        b = in.nextLongArray(m);

        long[] arr = new long[(int)1e6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i*51 + j] = a[i] * b[j];
            }
        }

        long mult = Long.MIN_VALUE;
        int indToHide = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i*51 + j] > mult) {
                    mult = arr[i*51 + j];
                    indToHide = i;
                }
            }
        }

        mult = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i != indToHide && arr[i*51 + j] > mult) {
                    mult = arr[i*51 + j];
                }
            }
        }

        out.printLine(mult);

    }

}