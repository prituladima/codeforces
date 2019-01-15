package com.prituladima.codeforce.contests.contest963;

import com.prituladima.codeforce.GeekLong;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class AZnakoperemennayaSumma {
    private final long mod = (long) 1e9 + 9;
    private long n, k, a, b;
    private String s;

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        n = in.nextLong();
        a = in.nextLong();
        b = in.nextLong();
        k = in.nextLong();
        s = in.nextToken();

        long ans = 0;

        long c = bpow(b * inv(a) % mod, k);
        long geom = geom(c, n / k);
        for (int i = 0; i < k; i++) {
            long si = s.charAt(i) == '+' ? 1 : mod - 1;
            long t = bpow(b, i) * bpow(a, n - i) % mod;
            ans += si * t % mod;
            ans %= mod;
        }
        out.println(ans * geom % mod);
    }

    private long inv(long c) {
        return GeekLong.inv(c, mod);
    }

    private long geom(long c, long k) {
        if (c == 1) return k + 1;
        else return (1 - bpow(c, k + 1) + mod) * inv(1 - c + mod) % mod;
    }


    long bpow(long x, long n) {
        return GeekLong.bpow(x, n, mod);
    }
}