package com.prituladima.geeksforgeeks.math.fib;

public class FibonacciCoding {

    public static void main(String[] args) {
        int n = 143;
        System.out.printf("Fibonacci code word for %d is %s\n", n, fibonacciEncoding(n));
    }

    static int[] fib = new int[30];

    static int largestFiboLessOrEqual(int n) {
        fib[0] = 1;
        fib[1] = 2;

        int i;
        for (i = 2; fib[i - 1] <= n; i++)
            fib[i] = fib[i - 1] + fib[i - 2];

        return (i - 2);
    }

    static String fibonacciEncoding(int n) {
        int index = largestFiboLessOrEqual(n);
        char[] codeword = new char[index + 3];
        int i = index;

        while (n > 0) {
            codeword[i] = '1';
            n = n - fib[i];
            i = i - 1;
            while (i >= 0 && fib[i] > n) {
                codeword[i] = '0';
                i = i - 1;
            }
        }
        codeword[index + 1] = '1';
        codeword[index + 2] = '\0';
        return new StringBuilder().append(codeword).toString();
    }

}