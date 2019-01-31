package com.prituladima.codeforce.contests.contest1028;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class ANaidiKvadrat {
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        m = in.nextInt();
        char[][] mtx = in.nextCharMatrix(n, m);

        int x = 0, y = 0;
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mtx[i][j] == 'B') {
                    x = i+1;
                    y = j+1;
                    break outer;
                }
            }
        }

        int x1 = 0, y1 = 0;
        outer:
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (mtx[i][j] == 'B') {
                    x1 = i + 1;
                    y1 = j + 1;
                    break outer;
                }
            }
        }

        out.printLine((x1 + x)/2 + " " + (y1 + y)/2);


    }

}