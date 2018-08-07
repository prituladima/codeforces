package com.prituladima.geeksforgeeks.math.fib;


/**
 * @see "https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/"
 */
public class Fibonacci {


    static long fib(long n) {
        if (n == 0) return 0;
        long F[][] = {{1, 1}, {1, 0}};

        power(F, n - 1);

        return F[0][0];
    }

    static void power(long F[][], long n) {
        if (n == 0 || n == 1)
            return;

        long M[][] = {{1, 1}, {1, 0}};

        power(F, n / 2);
        multiply(F, F);

        if (n % 2 != 0)
            multiply(F, M);
    }

    static void multiply(long[][] F, long[][] M) {
        long x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        long y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        long z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        long w = F[1][0] * M[0][1] + F[1][1] * M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    public static void main(String args[]) {
        int n = 9;
        System.out.println(fib(n));
    }

}