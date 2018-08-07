package com.prituladima.geeksforgeeks.math.fib;


/**
 * @see "https://www.geeksforgeeks.org/zeckendorfs-theorem-non-neighbouring-fibonacci-representation/"
 */
public class ZeckendorfsTheorem {

    static int closestFibNumber(int n) {


        if (n == 0 || n == 1)
            return n;

        int f1 = 0, f2 = 1, f3 = 1;

        while (f3 <= n) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }

        return f2;
    }


    static void printFibRepresentatio(int n) {

        while (n > 0) {
            int f = closestFibNumber(n);
            System.out.printf("%d ", f);
            n -= f;
        }

    }


    public static void main(String[] args) {
        int n = 30;
        printFibRepresentatio(n);
    }


}
