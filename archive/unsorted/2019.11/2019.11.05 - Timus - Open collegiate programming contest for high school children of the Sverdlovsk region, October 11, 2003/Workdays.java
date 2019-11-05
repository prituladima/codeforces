package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class Workdays {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        out.println(in.nextInt()*(long)(in.nextInt() + 1));
    }
}
