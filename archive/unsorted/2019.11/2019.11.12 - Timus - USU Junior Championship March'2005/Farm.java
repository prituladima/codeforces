package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.math.BigInteger;

import static com.prituladima.geeksforgeeks.math.GeeksMath.bpow;

public class Farm {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        if (n == 1) out.println("1 2 3");
        else if (n == 2) out.println("3 4 5");
        else out.println(-1);

    }
}
