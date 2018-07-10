package com.prituladima.codeforce.jmh;

import org.openjdk.jmh.annotations.Benchmark;

public class TestJMH {

    @Benchmark
    public void measureMod() {
        boolean res = 1000000007 % 2 == 0;
    }

    @Benchmark
    public void measureBitAnd() {
        boolean res = (1000000007 & 1) == 0;
    }


}
