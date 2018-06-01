package com.prituladima.dp;

public class NaiveImpl implements DPAlgo {

    public int fib(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }


    public int lcs(char[] X, char[] Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X[m - 1] == Y[n - 1])
            return 1 + lcs(X, Y, m - 1, n - 1);
        else
            return Math.max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
    }


    @Override
    public int nCr(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return nCr(n - 1, k) + nCr(n - 1, k - 1);
        }
    }

    @Override
    public int lrs_lenght(char[] S, int l) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new NaiveImpl().nCr(5, 3));
    }

}