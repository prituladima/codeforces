package com.prituladima.codeforce.contests.contest1047;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;
import com.prituladima.yaal.numbers.IntegerUtils;

public class CUvelichitNOD {
    int MAX = (int) 15e6;
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        array = in.nextIntArray(n);

        int[] lpf = IntegerUtils.enumLowestPrimeFactors(MAX + 1);
        int[] count = new int[MAX + 1];
        int gcd = GeekInteger.gcd(array);
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] /= gcd;

            while (array[i] > 1) {
                int potentialGCD = lpf[array[i]];
                while (array[i] % potentialGCD == 0) array[i] /= potentialGCD;
                max = Math.max(max, ++count[potentialGCD]);
            }
        }

        if (max == 0) out.printLine(-1);
        else out.printLine(n - max);

    }

}