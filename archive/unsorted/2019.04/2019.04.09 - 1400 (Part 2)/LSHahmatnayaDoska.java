package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LSHahmatnayaDoska {
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
        n = in.nextInt();
        int[][][] M = new int[4][n][n];
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    M[k][i][j] += in.readCharacter() == '1' ? 1 : 0;
                }
            }
        }
        List<List<Integer>> perm = GeekInteger.getAllPermutations(4);
        ans = INF;
        for (List<Integer> order : perm) {
            int cur = 0;
            for (int i1 = 0; i1 < order.size(); i1++) {
                int k = order.get(i1);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i1 == 0 || i1 == 2) {
                            if ((i + j) % 2 == 0 && M[k][i][j] == 0)
                                cur++;
                            if ((i + j) % 2 == 1 && M[k][i][j] == 1)
                                cur++;
                        } else {
                            if ((i + j) % 2 == 0 && M[k][i][j] == 1)
                                cur++;
                            if ((i + j) % 2 == 1 && M[k][i][j] == 0)
                                cur++;
                        }
                    }
                }
            }
            ans = Math.min(ans, cur);
        }
        out.printLine(ans);
    }
}