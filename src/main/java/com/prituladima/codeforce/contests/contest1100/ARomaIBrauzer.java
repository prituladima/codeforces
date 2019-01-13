package com.prituladima.codeforce.contests.contest1100;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class ARomaIBrauzer {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int n = in.nextInt(), k = in.nextInt();
        int[] _a = in.nextArr(n);

        int max = Integer.MIN_VALUE;
        for (int b = 1; b < n; b++) {
            int[] a = _a.clone();
            for (int i = b - 1; i < n; i += k) {
                a[i] = 0;
            }
            for (int i = b - 1; i > -1; i -= k) {
                a[i] = 0;
            }

            int e = 0;
            int s = 0;
            for (int i = 0; i < n; i++) {
                e += a[i] == 1 ? 1 : 0;
                s += a[i] == -1 ? 1 : 0;
            }
        max = Math.max(max, Math.abs(e - s));
        }

        out.print(max);
    }
}
