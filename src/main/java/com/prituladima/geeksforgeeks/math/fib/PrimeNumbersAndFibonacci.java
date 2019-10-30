package com.prituladima.geeksforgeeks.math.fib;

import com.prituladima.yaal.numbers.IntegerUtils;


public class PrimeNumbersAndFibonacci {


    public static void main(String[] args) {
        int n = 1000;
        printPrimeAndFib(n);

    }

    static boolean isSquare(int n) {
        int sqrt_ = (int) Math.sqrt(n);
        return sqrt_ * sqrt_ == n;
    }

    static void printPrimeAndFib(int n) {

        boolean[] prime = IntegerUtils.generatePrimarilyTable(n + 1);

        for (int i = 2; i <= n; i++)
            if (prime[i] && (isSquare(5 * i * i + 4) || isSquare(5 * i * i - 4)))
                System.out.println(i);


    }

}
