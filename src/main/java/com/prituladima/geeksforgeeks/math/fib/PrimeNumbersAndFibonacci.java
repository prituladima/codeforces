package com.prituladima.geeksforgeeks.math.fib;

import java.util.Arrays;

public class PrimeNumbersAndFibonacci {


    public static void main(String[] args) {
        int n = 1000;
        printPrimeAndFib(n);

    }


    static boolean[] sieve(int n) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);

        sieve[0] = sieve[1] = false;

        for (int i = 2; i <= n; i++)
            if (sieve[i])
                for (int j = i * i; j <= n; j += i)
                    sieve[j] = false;

        return sieve;
    }

    static boolean isSquare(int n) {

        int sqrt_ = (int) Math.sqrt(n);
        return sqrt_ * sqrt_ == n;

    }

    static void printPrimeAndFib(int n) {

        boolean[] prime = sieve(n);

        for (int i = 2; i <= n; i++)
            if (prime[i] && (isSquare(5 * i * i + 4) || isSquare(5 * i * i - 4)))
                System.out.println(i);


    }

}
