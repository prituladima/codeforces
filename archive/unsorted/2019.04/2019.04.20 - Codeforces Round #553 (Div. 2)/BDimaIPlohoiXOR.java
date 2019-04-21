package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class BDimaIPlohoiXOR {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "TAK", NO = "NIE";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;
    int[][] mtx;
    int[] res;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        mtx = in.nextIntMatrix(n, m);


        for (int i = 0; i < n; i++) ans ^= mtx[i][0];

        if (ans == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if ((mtx[i][0] ^ mtx[i][j]) != 0) {
                        out.printLine(YES);
                        res = new int[n];
                        Arrays.fill(res, 1);
                        res[i] = j + 1;
                        out.printLine(res);
                        return;
                    }
                }
            }
            out.printLine(NO);
        } else {
            out.printLine(YES);
            res = new int[n];
            Arrays.fill(res, 1);
            out.print(res);
        }
    }

}