package com.prituladima.codeforce.contests.contest1111;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class CIzobretatelniiShelchok {
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        t = in.nextInt();
        n = in.nextInt();
        m = in.nextInt();
        array = in.nextIntArray(n);
        s = in.nextToken();
        chars = s.toCharArray();

        L = in.nextLong();
        R = in.nextLong();

        pairs = in.nextIntPairArray(n);

        sort(pairs);

        out.printLine(ans);
        out.printPairList(pairsAns);

    }

}