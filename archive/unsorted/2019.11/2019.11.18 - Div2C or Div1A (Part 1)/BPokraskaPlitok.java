package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.LongIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;
import com.prituladima.yaal.numbers.IntegerUtils;

import java.util.List;

public class BPokraskaPlitok {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long n = in.nextLong();
        final List<LongIntPair> factorize = IntegerUtils.factorize(n);
        if(factorize.size() == 1){
            out.println(factorize.get(0).first);
        }else {
            out.println(1);
        }

    }
}
