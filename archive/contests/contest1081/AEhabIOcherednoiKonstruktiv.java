package com.prituladima.codeforce.contests.contest1081;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class AEhabIOcherednoiKonstruktiv {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int i = in.nextInt();
        if (i == 1) {
            out.print(-1);
            return;
        }
        out.println(i + " " + i);
    }
}
