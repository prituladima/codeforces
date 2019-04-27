package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class BMaksimalniiPodpryamougolnik {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        long[] a = in.nextLongArray1(n);
        long[] b = in.nextLongArray1(m);

        long[] ansA = new long[n + 1];
        long[] ansB = new long[m + 1];

        long x = in.nextLong();
        a = GeekInteger.calculatePrefixSum(a);
        b = GeekInteger.calculatePrefixSum(b);

        for (int i = 1; i <= n; i++) {
            long mi = (int) 1e9 + 2;
            for (int j = 0; j <= (n - i); j++) {
                mi = Math.min(a[j + i] - a[j], mi);
            }
            ansA[i] = mi;
        }
        //
        for (int i = 1; i <= m; i++) {
            long mi = (int) 1e9 + 2;
            for (int j = 0; j <= (m - i); j++) {
                mi = Math.min(b[j + i] - b[j], mi);
            }
            ansB[i] = mi;
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                long z = ansA[i] * ansB[j];
                if (z <= x) {
                    ans = Math.max(ans, i * j);
                }
            }
        }

        out.printLine(ans);

    }
}