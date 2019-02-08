package com.prituladima.codeforce.contests.contest1100;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class BSborkaKontesta {

    private static class MulSet {

        private Map<Integer, Integer> ms = new HashMap<>();
        private int min = Integer.MAX_VALUE;

        public void add(int a) {
            ms.merge(a, 1, Integer::sum);
            min = Math.min(min, ms.get(a));
        }

        private int min() {
            return min;
        }
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int[] a = in.nextArr(m);
        StringBuilder ans = new StringBuilder();

        int[] ms = new int[n + 1];

        int need = 0;
        for (int i = 0; i < m; i++) {
            if (ms[a[i]] == 0) need++;
            ms[a[i]]++;

            if (need == n) {
                for (int j = 1; j <= n; j++) {
//                    need--;
                    ms[j]--;
                    if(ms[j] == 0) need--;
                }
                ans.append(1);
            } else
                ans.append(0);

        }
        out.print(ans.toString());
    }
}