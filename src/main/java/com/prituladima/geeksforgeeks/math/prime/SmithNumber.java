package com.prituladima.geeksforgeeks.math.prime;

import java.util.Scanner;

/**
 * @see "https://practice.geeksforgeeks.org/problems/smith-number/0"
 */

public class SmithNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            System.out.println(isSmithNumber(scanner.nextLong()) ? 1 : 0);
        }

    }


    static boolean isSmithNumber(long n) {
        return sumOfDig(n) == factorizeSum(n) && !isPrime(n);
    }

    static boolean isPrime(long n) {
        if ((n & 1) == 0) {
            return false;
        }
        long f = 3;
        while (f * f <= n) {
            if (n % f == 0)
                return false;
            else
                f += 2;
        }

        return true;

    }

    static long factorizeSum(long n) {
        int sum = 0;
        while (n % 2 == 0) {
            sum += 2;
            n /= 2;
        }

        long f = 3;
        while (f * f <= n) {
            if (n % f == 0) {
                sum += sumOfDig(f);
                n /= f;
            } else {
                f += 2;
            }
        }

        if (n != 1) {
            sum += sumOfDig(n);
        }

        return sum;
    }

    static long sumOfDig(long n) {
        long sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }


}
