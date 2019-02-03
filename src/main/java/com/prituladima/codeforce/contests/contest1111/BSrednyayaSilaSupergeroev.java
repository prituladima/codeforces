package com.prituladima.codeforce.contests.contest1111;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;
import com.prituladima.yaal.misc.ArrayUtils;

public class BSrednyayaSilaSupergeroev {
    int t, n, m, k, ans;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        k = in.nextInt();
        m = in.nextInt();
        a = in.nextIntArray(n);
        ArrayUtils.sort(a);

        double max = 0;

        for (int i = n - 1; i >= 0; i--) {
            ans += a[i];
            if (i > m) continue;
            max = Math.max(max, (double) (ans + Math.min((n - i) * k, m - i)) / (n - i));
        }
        out.printLine(max);
    }
}