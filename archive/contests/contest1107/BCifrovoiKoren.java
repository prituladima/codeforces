package com.prituladima.codeforce.contests.contest1107;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class BCifrovoiKoren {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.nextInt();
        while (n-- > 0) {
            long k;
            long x;
            k = in.nextLong();
            x = in.nextLong();

            out.printLine((k - 1) * 9 + x);

        }
    }

}