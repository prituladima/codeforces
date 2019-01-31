package com.prituladima.codeforce.contests.contest1003;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class CSilnayaZhara {
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        k = in.nextInt();
        array = in.nextIntArray(n);

        double max = (double) Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            long cur_Sum = 0;
            for(int j = 0; j < i; j++){
                cur_Sum += array[j];
            }
            max = max(max, (double) cur_Sum/i);

            for (int j = i; j < n; j++) {
                cur_Sum -= array[j - i];
                cur_Sum += array[j];
                max = max(max, (double) cur_Sum/i);

            }
        }

        out.print(max);
    }

}