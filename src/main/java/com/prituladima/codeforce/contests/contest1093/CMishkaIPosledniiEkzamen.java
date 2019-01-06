package com.prituladima.codeforce.contests.contest1093;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class CMishkaIPosledniiEkzamen {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int n = in.nextInt();
        long[] b = in.nextArrL(n / 2);

        long[] a = new long[n];

        a[n - 1] = b[0];

        for (int i = 1; i < n / 2; i++) {
            long min = Math.min(b[i], a[n - i]);
            a[n - 1 - i] = min;
            a[i] = b[i] - min;

            if (a[i] < a[i - 1]) {
                long diff = a[i - 1] - a[i];
                a[i] += diff;
                a[n - 1 -i] -= diff;
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(a[i] + " ");
        }
    }
}
