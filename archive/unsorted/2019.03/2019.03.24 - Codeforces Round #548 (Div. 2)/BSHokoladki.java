package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class BSHokoladki {
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        array = in.nextIntArray(n);

        int req = array[array.length - 1];
        long ans = req;

        for(int i = array.length - 2; i >= 0; i--){
            req = Math.max(0, Math.min(req - 1, array[i]));
            ans += req;
        }

        out.printLine(ans);

    }

}