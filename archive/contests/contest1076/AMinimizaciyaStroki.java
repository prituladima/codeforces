package com.prituladima.codeforce.contests.contest1076;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class AMinimizaciyaStroki {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        String s = in.nextToken();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) - s.charAt(i - 1) < 0) {
                out.println(new StringBuilder(s).delete(i - 1, i).toString());
                return;
            }
        }
        out.println(new StringBuilder(s).delete(n - 1, n).toString());


    }
}
