package com.prituladima.codeforce;

import com.prituladima.geeksforgeeks.dp.DynamicProgramming;
import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KSdelaiKvadrat {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;
    List<Integer> setSQ = new ArrayList<>();
    int MAX = (int) 2e9 + 10;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        for (int i = 1; i * i <= MAX; i++) {
            setSQ.add(i * i);
        }
        char[] our = String.valueOf(n).toCharArray();
        ans = -INF;
        for (int qc : setSQ) {
            char[] chars = String.valueOf(qc).toCharArray();
            int lcs = DynamicProgramming.lcs(chars, our, chars.length, our.length);
            if(lcs == chars.length)
                ans = Math.max(ans, lcs);
        }
        if (ans <= 0) {
            out.printNoAns();
        } else
            out.printLine(String.valueOf(n).toCharArray().length - ans);

    }

}