package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class DMinimalnayaTriangulyaciya {
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        long min = Integer.MAX_VALUE;

        if (n == 3) {
            out.printLine(6);
            return;
        }
        for (int i = 1; i <= n; i++) {
            long localLong = 0;
            for (int j = 1; j <= n - 1; j++) {
                localLong += j * (j + 1);
            }
            localLong += n;
            if (i == 1) localLong -= (n + 2);
            else if (i == n) localLong -= (n + n * (n - 1));
            else localLong -= (i * (i - 1) + i * (i + 1));

            min = Math.min(min, i * localLong);
        }
        out.printLine(min);


    }

}