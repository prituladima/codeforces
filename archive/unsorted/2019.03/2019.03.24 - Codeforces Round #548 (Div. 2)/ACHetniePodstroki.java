package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class ACHetniePodstroki {
    int t, n, m, k; long ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        s = in.nextToken();
        chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(Integer.parseInt(String.valueOf(chars[i])) % 2 == 0)
            ans += (i +1);
        }

        out.printLine(ans);
    }

}