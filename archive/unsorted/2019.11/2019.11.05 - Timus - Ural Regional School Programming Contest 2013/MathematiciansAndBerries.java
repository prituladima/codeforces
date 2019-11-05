package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class MathematiciansAndBerries {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a1 = in.nextInt(), b1 = in.nextInt();
        int a2 = in.nextInt(), b2 = in.nextInt();
        int a3 = in.nextInt(), b3 = in.nextInt();

        out.printf("%s %s\n", a1 - a3, a2 - a1);
    }
}
