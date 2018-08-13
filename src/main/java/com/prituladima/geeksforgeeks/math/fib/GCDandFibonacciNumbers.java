package com.prituladima.geeksforgeeks.math.fib;

import java.util.*;
import java.lang.*;
import java.io.*;

public class GCDandFibonacciNumbers {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {

            System.out.println(fib(gcd(s.nextInt(), s.nextInt())));

        }


    }

    static int fib(int n) {

        if (n == 0 || n == 1) return n;


        int f1 = 0;
        int f2 = 1;
        int f3;

        int i = 2;

        while (i != n) {
            f3 = (f1 % m + f2 % m) % m;
            f1 = f2;
            f2 = f3;
            i++;

        }

        return (f1 % m + f2 % m) % m;

    }

    static int m = 100;

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
