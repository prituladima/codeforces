package com.prituladima.codeforce.contests.contest1080;

import com.prituladima.codeforce.GeekLong;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class DOlyaIMagicheskiiKvadrat {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

//        int[] maxLimit = new int[(int)1e9];
        long[] need = new long[32];
        for (int i = 1; i < need.length; i++) {
            need[i] = (GeekLong.bpow(2, i) - 1) * 2 - i;
        }

        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long k = in.nextLong();
            long maxAllowed = GeekLong.bpow(4, n) - 1;
            maxAllowed /= 3;

            if (maxAllowed > k) {
                out.println("NO");
                return;
            }

            for (int i = 1; i < need.length; i++) {
                
            }



        }

    }
}
