package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class TwoGangsters {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.nextInt(), b = in.nextInt();
        out.printf("%d %d\n", b - 1, a - 1);
    }
}
