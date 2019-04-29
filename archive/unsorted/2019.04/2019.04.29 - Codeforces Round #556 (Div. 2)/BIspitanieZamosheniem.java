package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class BIspitanieZamosheniem {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes".toUpperCase(), NO = "No".toUpperCase();
    boolean[] used;
    Map<Integer, Set<Integer>> graph;
    char[][] MTX;
    int colored = 0;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        MTX = in.nextCharMatrix(n, n);
        t = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (MTX[i][j] == '.') {
                    t++;
                }
            }
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (match(MTX, i, j)) color(MTX, i, j);

            }
        }

        if (colored != t) {
            out.printLine(NO);
        } else {
            out.printLine(YES);
        }
    }

    private void color(char[][] mtx, int i, int j) {
        mtx[i][j] = mtx[i - 1][j] = mtx[i][j - 1] = mtx[i + 1][j] = mtx[i][j + 1] = '+';
        colored += 5;
    }

    private boolean match(char[][] mtx, int i, int j) {
        return mtx[i][j] == '.' && mtx[i - 1][j] == '.' && mtx[i][j - 1] == '.' && mtx[i + 1][j] == '.' && mtx[i][j + 1] == '.';
    }

}