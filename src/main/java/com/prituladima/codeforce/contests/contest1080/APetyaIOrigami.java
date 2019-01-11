package com.prituladima.codeforce.contests.contest1080;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class APetyaIOrigami {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        long n = in.nextLong(), k = in.nextLong();

        long ans = 0;
        ans += (2 * n + k - 1) / k;
        ans += (5 * n + k - 1) / k;
        ans += (8 * n + k - 1) / k;

        out.println(ans);


    }
}
