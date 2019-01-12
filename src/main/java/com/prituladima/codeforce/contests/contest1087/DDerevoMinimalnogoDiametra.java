package com.prituladima.codeforce.contests.contest1087;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DDerevoMinimalnogoDiametra {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), s = in.nextInt();
        int[] a = new int[2*(n -1)];
        for (int i = 0; i < 2*(n - 1); i++) {
            a[i] = in.nextInt();
        }
        Map<Integer, Integer> ms = GeekInteger.multiSet(a);
        int ans = 0;
        for (int i : ms.keySet()) {
            ans += (ms.get(i) == 1) ? 1 : 0;
        }
        out.print(2*(double)s/(double) ans);
    }
}
