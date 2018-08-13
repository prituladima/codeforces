package com.prituladima.geeksforgeeks.math.fib;

public class NbonacciNumbers {

    public static void main(String[] args) {

        int N = 5, M = 15;
        bonacciseries(N, M);


    }

    static void bonacciseries(int N, int M){

        int[] fib = new int[M + 1];
        for (int i = 0; i < N; i++) {
            fib[i] = 0;

        }

        fib[N] = 1;
        fib[N + 1] = 1;

        for (int i = N + 2; i <= M; i++) {
            fib[i] = 2 * fib[i - 1] - fib[i - N - 1];

        }

        for (int i = 0; i <= M; i++)
            System.out.printf("%d ", fib[i]);
    }


}
