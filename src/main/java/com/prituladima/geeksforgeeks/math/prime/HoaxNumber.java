package com.prituladima.geeksforgeeks.math.prime;

import java.util.HashSet;
import java.util.Scanner;


/**
 * @see "https://www.geeksforgeeks.org/hoax-number/"
 */
public class HoaxNumber {


    static boolean isHoax(long n) {
        return !isPrime(n) && sumOfNumbers(n) == sumOfDistictFactorizations(n);
    }


    static boolean isPrime(long n) {
        if (n % 2 == 0) {
            return false;
        }

        long f = 3;

        while (f * f <= n) {
            if (n % f == 0) {
                return false;
            } else {
                f += 2;
            }
        }

        return n != 1;
    }

    static long sumOfDistictFactorizations(long n) {
        HashSet<Long> set = new HashSet<>();
        while (n % 2 == 0) {
            set.add(2L);
            n /= 2;
        }

        long f = 3;
        while (f * f <= n) {

            if (n % f == 0) {
                set.add(f);
                n /= f;
            } else
                f += 2;

        }


        if (n != 1) {
            set.add(n);
        }

        int disSum = 0;
        for (long cur : set) {
            disSum += sumOfNumbers(cur);
        }

        return disSum;
    }

    static long sumOfNumbers(long n) {
        long sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

}