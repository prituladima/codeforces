package com.prituladima.codeforce.contests.contest1076;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class BVichitanieDelitelya {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        long n = in.nextLong();

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                out.print((n - i)/2+1);
            return;}
        }

        out.print(1);
    }


    static boolean isPrime(long n) {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (long i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }
}
