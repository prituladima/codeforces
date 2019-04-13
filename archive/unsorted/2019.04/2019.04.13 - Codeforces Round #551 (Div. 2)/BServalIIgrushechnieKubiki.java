package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class BServalIIgrushechnieKubiki {
    int t, n, m, k, h, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns, b;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;
    int[][] MTX;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        m = in.nextInt();
        h = in.nextInt();

        a = in.nextIntArray(m);
        b = in.nextIntArray(n);
        MTX = in.nextIntMatrix(n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (MTX[i][j] != 0) {
                    MTX[i][j] = Math.min(a[j], b[i]);
                }
                out.print(MTX[i][j]).printSpace();
            }
            out.printLine();
        }





    }

}