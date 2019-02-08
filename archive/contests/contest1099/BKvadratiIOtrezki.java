package com.prituladima.codeforce.contests.contest1099;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class BKvadratiIOtrezki {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = (int) Math.ceil(Math.sqrt(n));
        int ans = k + n / k + (n % k == 0 ? 0 : 1);
        out.print(ans);
    }

}