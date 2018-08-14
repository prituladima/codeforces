package com.prituladima.geeksforgeeks.math.fib;

import java.math.BigInteger;

public class FactorialOfEachElementInFibonacciSeries {

    public static void main(String[] args) {

        int limit = 50;
        printfibFactorials(limit);
    }


    static void printfibFactorials(int limit) {

        int[] fib = new int[20];
        BigInteger[] fac = new BigInteger[20];

        fib[0] = 0;
        fac[0] = BigInteger.valueOf(1);

        fib[0] = 1;
        fac[1] = BigInteger.valueOf(1);


        for (int i = 2; ; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];


            if (fib[i] > limit) {
                break;
            }

            fac[i] = fac[i - 1];
            for(int m = fib[i-1] + 1; m <= fib[i]; m++){
                fac[i] = fac[i].multiply(BigInteger.valueOf(m));
            }

            System.out.printf("%s ", fac[i].toString());


        }


    }


}
