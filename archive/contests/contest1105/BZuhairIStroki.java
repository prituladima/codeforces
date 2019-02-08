package com.prituladima.codeforce.contests.contest1105;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;


public class BZuhairIStroki {
    final long MODULO = (long) 1e9 + 9;
    final int INF = (int) 1e9;
    int n, k;
    int[] a;
    int ans;
    String s;

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        n = in.nextInt();
        k = in.nextInt();
        s = in.nextToken();
        char[] chars = s.toCharArray();

        int max = Integer.MIN_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int cur = 0;
            int cou = 0;
            for (int i = 0; i < n; i++) {
                if (chars[i] == c) {
                    cou++;
                }else {
                    cou = 0;
                }
                if (cou == k) {
                    cur++;
                    cou = 0;
                }

            }
            max = Math.max(max, cur);
        }

        out.println(max);

    }

}