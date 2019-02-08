package com.prituladima.codeforce.contests.contest1047;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class BPokritTochki {
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        pairs = in.nextIntPairArray(n);

        ans = Integer.MIN_VALUE;

        for (int i = 0; i < pairs.length; i++) {
            ans = Math.max(ans, pairs[i].first + pairs[i].second);
        }
//        sort(pairs);

        out.printLine(ans);

    }

}