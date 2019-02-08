package com.prituladima.codeforce.contests.contest1062;

import static com.prituladima.codeforce.GeekBit.isPowerOfTwo;
import static com.prituladima.codeforce.GeekBit.nextPowerOf2;
import static com.prituladima.codeforce.GeekDP.Pair;

import com.prituladima.codeforce.InputReader;
import com.prituladima.yaal.generated.collections.pair.LongIntPair;

import java.io.PrintWriter;

import java.util.*;

import static com.prituladima.yaal.numbers.IntegerUtils.factorize;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;


public class BMatematika {
    final long MODULO = (long) 1e9 + 9;
    final int INF = (int) 1e9;
    long n, m;
    int[] a;
    long L, R;
    long ans;
    int min = INF, max = -INF;
    String s;
    private List<Pair> pairs = new ArrayList<>();

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        if(n == 1){
            out.printf("%d %d\n", n, 0);
            return;
        }

        List<LongIntPair> factorize = factorize(n);

        long ans = 1;
        long max = -INF;
        long min = INF;
        for (int i = 0; i < factorize.size(); i++) {
            ans *= factorize.get(i).first;
            max = Long.max(max, factorize.get(i).second);
            min = Long.min(min, factorize.get(i).second);
        }

        int pow = 0;
        long max1 = max;
        if(!isPowerOfTwo(max1) || max != min){
            max1 = nextPowerOf2(max1);
            pow++;
        }

        while (max1 % 2 == 0){
            max1 /= 2;
            pow++;
        }


        out.printf("%d %d\n", ans, pow);
    }




}