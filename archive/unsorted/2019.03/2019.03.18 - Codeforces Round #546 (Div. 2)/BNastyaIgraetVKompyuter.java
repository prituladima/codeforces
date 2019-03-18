package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class BNastyaIgraetVKompyuter {
    int t, n, m, k, ans;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        k = in.nextInt();

        int min = Math.min(n - k, k - 1);
        int max = Math.max(n - k, k - 1);
//        out.printLine(Math.min(3 + 5 * min + 3 * max, 3 + 3 * min + 5 * max));

        out.printLine(2 * n + max + 2 * min + 1);
    }

}