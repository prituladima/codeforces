package com.prituladima.codeforce.contests.contest1013;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class TaskA {
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        array = in.nextIntArray(n);
        arrayAns = in.nextIntArray(n);

        long sum1 = 0;
        long sum2 = 0;
        for (int i : array) {
            sum1 += i;
        }

        for (int i : arrayAns) {
            sum2 += i;
        }
        if(sum2 > sum1){
            out.print("No");

        }else

        out.printLine("Yes");

    }

}