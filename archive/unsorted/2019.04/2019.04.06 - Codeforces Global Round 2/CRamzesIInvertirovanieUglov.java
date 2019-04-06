package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class CRamzesIInvertirovanieUglov {
    int INF = Integer.MAX_VALUE;
    int t, n, m, k, ans;
    int[] array, arrayAns;
    int[][] A, B;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        m = in.nextInt();
        boolean rows[] = new boolean[n];
        boolean cols[] = new boolean[m];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (in.nextInt() != 0) {
                        rows[j] ^= true;
                        cols[k] ^= true;
                    }
                }
            }
        }
        boolean can = true;
        for (int i = 0; i < n; i++) {
            if (rows[i]) {
                can = false;
            }
        }
        for (int i = 0; i < m; i++) {
            if (cols[i]) {
                can = false;
            }
        }
        out.print(can ? "Yes" : "No");
    }

}