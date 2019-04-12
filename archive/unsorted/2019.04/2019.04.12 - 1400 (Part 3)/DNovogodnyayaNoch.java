package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class DNovogodnyayaNoch {
    long t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextLong();
        k = in.nextLong();

        if (k == 1) {
            out.printLine(n);
            return;
        }

        int len = Long.toBinaryString(n).length();
        char[] chars = new char[len];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = '1';
        }

        out.printLine(Long.parseLong(new String(chars), 2) );


    }

}