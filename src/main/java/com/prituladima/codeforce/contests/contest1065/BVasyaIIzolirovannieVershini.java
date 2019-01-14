package com.prituladima.codeforce.contests.contest1065;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class BVasyaIIzolirovannieVershini {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long n = in.nextLong(), m = in.nextLong();
        long min = Math.max(n - 2 * m, 0);

        long max = 0;//Math.max(n - 1 - m, 0);
//        long prev = 0;
        for (long i = 0; i <= n; i++) {
            long cur = i * (i - 1) / 2;
//            long next = (i + 1) * (i) / 2;
            if (m <= cur) {
                max = (n - i);
                break;
            }
//            prev = cur;
        }

        out.println(min + " " + max);

    }
}
