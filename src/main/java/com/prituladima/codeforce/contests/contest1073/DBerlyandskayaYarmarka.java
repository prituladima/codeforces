package com.prituladima.codeforce.contests.contest1073;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class DBerlyandskayaYarmarka {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        long T = in.nextLong();
        long[] a = in.nextArrL(n);

        long min_ = Integer.MAX_VALUE;
        for (long l : a) {
            min_ = Math.min(min_, l);
        }

        long ans = 0L;

        while (T >= min_) {

            long sum = 0L, cnt = 0L;

            for (int i = 0; i < n; i++) {
                if (T >= a[i]) {
                    T -= a[i];
                    sum += a[i];
                    cnt++;
                }
            }
            ans += cnt + cnt * (T / sum);
            T %= sum;
        }

        out.print(ans);
    }

}