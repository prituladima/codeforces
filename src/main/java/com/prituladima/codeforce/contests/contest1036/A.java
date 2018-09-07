package com.prituladima.codeforce.contests.contest1036;

import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        long k = in.nextLong(), n = in.nextLong();
        out.print((n + k - 1)/k);

    }
}
