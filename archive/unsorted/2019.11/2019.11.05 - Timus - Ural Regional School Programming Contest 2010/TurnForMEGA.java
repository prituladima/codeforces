package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class TurnForMEGA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int k = in.nextInt(), n = in.nextInt();
        int[] a = in.nextIntArray(n);

        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += a[i];
            cur = Math.max(0, cur - k);
        }
        out.println(cur);
    }
}
