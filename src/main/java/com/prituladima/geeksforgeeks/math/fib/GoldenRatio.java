package com.prituladima.geeksforgeeks.math.fib;

/**
 * @see "https://www.geeksforgeeks.org/find-nth-fibonacci-number-using-golden-ratio/"
 */
public class GoldenRatio {


    final static double PHI = 1.6180339887498948482;


    static int f[] = { 0, 1, 1, 2, 3, 5 };
    static int fib(int n){


        // Fibonacci numbers for n < 6
        if (n < 6)
            return f[n];

        // Else start counting from
        // 5th term
        int t = 5, fn = 5;

        while (t < n) {
            fn = (int)Math.round(fn * PHI);
            t++;
        }

        return fn;
    }

    public static void main(String[] args) {
        System.out.println(fib(9));
    }

}
