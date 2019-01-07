package com.prituladima.codeforce.contests.contest1079;

import com.prituladima.codeforce.GeekMath;
import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class AStoloviePribori {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int[] a = in.nextArr(n);

        Map<Integer, Integer> co = new HashMap<>();

        for (int i = 0; i < n; i++) {
            co.merge(a[i], 1, Integer::sum);
        }

        int amountIn = co.keySet().size();
        int max = Integer.MIN_VALUE;
        for (Integer integer : co.keySet()) {
            max = Math.max(max, co.get(integer));
        }
        int cou = GeekMath.ceiling(max, k);

        out.println(cou*amountIn*k - n);

    }
}
