package com.prituladima.codeforce.contests.contest1036;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class BV2 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        long q = in.nextLong();
        while (q-- > 0) {
            long n = in.nextLong(), m = in.nextLong(), k = in.nextLong();
            if (k < Long.max(m, n)) {
                out.println(-1);
            } else {

                long min_ = Long.min(n, m);
                long max_ = Long.max(n, m);
                long dif_ = (max_ - min_);

                out.println(min_ + (dif_ - dif_ % 2));
            }


        }


    }
}
