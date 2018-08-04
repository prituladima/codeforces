package com.prituladima.geeksforgeeks.math.factorization;


import java.util.*;

import static java.lang.StrictMath.max;

/**
 * @see "https://practice.geeksforgeeks.org/problems/largest-prime-factor/0"
 */
public class LargestPrimeFactor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            long n = scanner.nextLong();
            System.out.println(largestPrimeFactor(n));
        }
    }

    static long largestPrimeFactor(long n) {
        long ans = 1;

        while ((n & 1) == 0) {
            ans = 2;
            n /= 2;
        }

        long i = 3;
        while (i * i <= n) {
            if (n % i == 0) {
                ans = max(ans, i);
                n /= i;
            } else {
                i += 2;
            }

        }

        if (n != 1) ans = n;

        return ans;
    }

}