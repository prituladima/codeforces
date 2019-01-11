package com.prituladima.codeforce.contests.contest1096;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class BUdaleniePodstroki {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long mod = 998244353;

        int n = in.nextInt();
        char[] s = in.nextToken().toCharArray();

        int L = 1;
        int R = 1;

        char first = s[0];
        char last = s[n - 1];

        for (int i = 1; i < n; i++) {
            if (first != s[i]) break;
            L++;
        }

        for (int i = s.length - 2; i >= 0; i--) {
            if (last != s[i]) break;
            R++;
        }

        if (first != last) {
            out.println(
                    (L % mod + R % mod + 1)
            );
            return;
        }

        long ans = GeekInteger.multiplication(mod, R + 1, L + 1);

        out.println(ans);


    }
}
