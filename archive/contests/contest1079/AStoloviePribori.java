package com.prituladima.codeforce.contests.contest1079;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.Map;

public class AStoloviePribori {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int[] a = in.nextArr(n);

        Map<Integer, Integer> multiSet = GeekInteger.multiSet(a);

        int amountIn = multiSet.keySet().size();
        int max = Integer.MIN_VALUE;
        for (Integer integer : multiSet.keySet()) {
            max = Math.max(max, multiSet.get(integer));
        }
        int cou = GeekInteger.ceiling(max, k);

        out.println(cou * amountIn * k - n);

    }
}
