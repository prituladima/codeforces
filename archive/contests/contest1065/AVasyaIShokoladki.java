package com.prituladima.codeforce.contests.contest1065;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class AVasyaIShokoladki {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int t = in.nextInt();
        while (t-- > 0) {
            long s = in.nextInt();
            long a = in.nextInt();
            long b = in.nextInt();
            long c = in.nextInt();

            long all = s / c;

            out.println(all + (all / a) * b);
        }

    }
}
