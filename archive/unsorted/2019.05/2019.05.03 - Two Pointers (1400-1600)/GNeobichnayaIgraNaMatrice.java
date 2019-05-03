package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class GNeobichnayaIgraNaMatrice {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        final int n = in.nextInt();
        final int m = in.nextInt();
        final int k = in.nextInt();
        final int[][] a = in.nextIntMatrix(n, m);
        int finalAnsSum = 0;
        int toRemove = 0;
        for (int j = 0; j < m; j++) {
            int minI = -1;
            for (int i = 0; i < n; i++) {
                if (a[i][j] == 1) {
                    minI = i;
                    break;
                }
            }
            if (minI == -1) continue;
            int curSum = 0;
            int maxSum = 0;
            int L = 0;

            for (int i = minI; i < Math.min(n, minI + k); i++) {
                curSum += a[i][j];
            }
            maxSum = curSum;
            L = minI;

            for (int i = minI + k; i < n; i++) {
                curSum += a[i][j];
                curSum -= a[i - k][j];
                if (maxSum < curSum) {
                    L = i - k + 1;
                    maxSum = curSum;
                }
            }
            for (int i = 0; i < L; i++) {
                if (a[i][j] == 1) toRemove++;
            }
            finalAnsSum += maxSum;
        }
        out.print(finalAnsSum).space().printLine(toRemove);

    }
}