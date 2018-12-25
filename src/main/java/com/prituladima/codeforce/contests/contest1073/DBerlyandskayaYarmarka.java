package com.prituladima.codeforce.contests.contest1073;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class DBerlyandskayaYarmarka {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();

        long T = in.nextLong();

        long[] a = in.nextArrL(n);

        long min_ = Integer.MAX_VALUE;
        for (long l : a) {
            min_ = Math.min(min_, l);
        }

        long sum_line = 0L;
        long res_line = 0L;

        long temp_T = T;
        for (int i = 0; i < a.length; i++) {
            if (temp_T > 0 && temp_T - a[i] >= 0) {
                temp_T -= a[i];
                sum_line += a[i];
                res_line++;
            }
        }

        long ans = res_line * Math.max(1, T / sum_line);


        if (T > sum_line) {
            temp_T = T % sum_line;
            sum_line = 0L;
            res_line = 0L;

            while (temp_T >= min_) {
                for (int i = 0; i < a.length; i++) {
                    if (temp_T > 0 && temp_T - a[i] >= 0) {
                        temp_T -= a[i];
                        sum_line += a[i];
                        res_line++;
                    }
                }
            }


            ans += res_line;
        }

        out.print(ans);

    }


}
