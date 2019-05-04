package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class BDvoinayaMatrica {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        final int n = in.nextInt();
        final int m = in.nextInt();
        final int[][] a = in.nextIntMatrix(n, m);
        final int[][] b = in.nextIntMatrix(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                boolean ok = true;
                ok = Math.min(a[i][j-1], b[i][j-1]) < Math.min(a[i][j], b[i][j])
                        &&  Math.max(a[i][j-1], b[i][j-1]) < Math.max(a[i][j], b[i][j]);


                if(!ok){
                    out.printLine("Impossible");
                    return;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                boolean ok = true;
                ok = Math.min(a[i-1][j], b[i-1][j]) < Math.min(a[i][j], b[i][j])
                        &&  Math.max(a[i-1][j], b[i-1][j]) < Math.max(a[i][j], b[i][j]);


                if(!ok){
                    out.printLine("Impossible");
                    return;
                }
            }
        }

        out.printLine("Possible");

    }
}