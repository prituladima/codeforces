package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.math.BigInteger;

public class DivorceOfTheSevenDwarfs {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        BigInteger n = new BigInteger(in.nextToken());

        out.println(n.mod(BigInteger.valueOf(7)));
    }
}
