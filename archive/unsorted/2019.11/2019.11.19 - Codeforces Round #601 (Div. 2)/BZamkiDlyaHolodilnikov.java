package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Arrays;

public class BZamkiDlyaHolodilnikov {
    private static final int BITS = 31;
    private static final int MODULO = (int) 1e9 + 7;
    private static final String yes = "YES", no = "NO";
    private static final boolean MULTI_TEST = true;

    private void solve(InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = in.nextIntArray(n);

        if (n == 2 || m < n) {
            out.println(-1);
        } else {
            int minCost = Arrays.stream(a).sum() * 2;
            //safeSort(a);
            m -= n;
            int minPair = Integer.MAX_VALUE;
            int minI = -1;
            int minJ = -1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        if (a[i] + a[j] < minPair) {
                            minPair = a[i] + a[j];
                            minI = i;
                            minJ = j;
                        }
                    }
                }
            }

            minCost += m * minPair;

            out.println(minCost);
            for (int i = 0; i < m; i++)
                out.printf("%d %d\n", minI + 1, minJ + 1);

            out.printf("%d %d\n", n, 1);

            for (int i = 0; i < n - 1; i++) {
                out.printf("%d %d\n", i + 1, i + 2);
            }

        }

    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = MULTI_TEST ? in.nextInt() : 1;
        while (t-- > 0) {
            solve(in, out);
        }
    }

}
