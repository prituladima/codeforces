package com.prituladima.codeforce.contests.contest1004;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class BSonyaIVistavka {
    int n;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        while (n-- > 0) out.print(n & 1);
    }

}