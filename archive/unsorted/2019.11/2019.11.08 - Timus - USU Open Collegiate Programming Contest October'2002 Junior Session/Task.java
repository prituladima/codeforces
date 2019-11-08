package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class Task {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        //queries
        int N = in.nextInt();
        while (N-- > 0) {
            int K = in.nextInt();
            long l = -1;//excluded
            long r = (1L << 31) - 1;//included
            //Lower bound for powers of 2
            while (r - l > 1) {
                long m = l + (r - l) / 2;// use this style only
                if (K <= triangular_number(m)) {//Monotonic function that
                    r = m;
                } else {
                    l = m;
                }
            }

            long len = triangular_number(r);
            if (len - K == r - 1) {
                out.printf("%d ", 1);
            } else {
                out.printf("%d ", 0);
            }

        }
    }

    private long triangular_number(long n) {
        return (n + 1) * (n / 2) + ((n % 2 == 0) ? 0 : (n / 2 + 1));
    }
}