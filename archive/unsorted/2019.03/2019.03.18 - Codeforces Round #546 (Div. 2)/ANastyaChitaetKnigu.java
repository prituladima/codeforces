package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class ANastyaChitaetKnigu {
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        pairs = in.nextIntPairArray(n);
        m = in.nextInt();

//        ans = n;
        for (int i = pairs.length - 1; i >= 0; i--) {
            if(pairs[i].first > m || (pairs[i].second >= m && pairs[i].first <= m)) ans++;
            else break;
        }


        out.printLine(ans);


    }

}