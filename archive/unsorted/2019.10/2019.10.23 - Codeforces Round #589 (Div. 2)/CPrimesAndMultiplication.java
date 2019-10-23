package com.prituladima.codeforce;


import com.prituladima.yaal.generated.collections.pair.LongIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;


import java.util.*;

import static com.prituladima.geeksforgeeks.math.GeeksMath.power_mod;
import static com.prituladima.yaal.numbers.IntegerUtils.factorize;


public class CPrimesAndMultiplication {

    int MODULO = (int) 1e9 + 7;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        long x = in.nextLong();
        long n = in.nextLong();

        long ans = 1;

        List<LongIntPair> primeFactors = factorize(x);
        for (LongIntPair primeFactor : primeFactors) {
            long pow = 0;
            long p = primeFactor.first;
            long prime = primeFactor.first;
            for (int i = 0; i <= 63; i++) {
                long d = n / p;
                if(d <= 0) break;
                pow += d;

                long overflowCheck = p;
                p*=prime;//check for overflow
                if(p / overflowCheck != prime){
                    break;
                }
            }

            ans *= power_mod(prime, pow, MODULO);
            ans %= MODULO;

        }


        out.println(ans);
    }

}