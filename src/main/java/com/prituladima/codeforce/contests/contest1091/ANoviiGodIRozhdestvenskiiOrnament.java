package com.prituladima.codeforce.contests.contest1091;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class ANoviiGodIRozhdestvenskiiOrnament {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int y = in.nextInt(), b = in.nextInt() - 1, r = in.nextInt() - 2;
        int min_ = Math.min(y, Math.min(b, r));

        out.println(min_ * 3 + 3);

    }
}
