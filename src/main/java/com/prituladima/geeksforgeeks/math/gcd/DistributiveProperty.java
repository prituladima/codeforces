package com.prituladima.geeksforgeeks.math.gcd;

/**
 * @see "https://www.geeksforgeeks.org/gcd-lcm-distributive-property/"
 */
public class DistributiveProperty {

    long value1(long x, long y, long z) {
        return gcd(lcm(x, y), lcm(x, z));
    }

    long value2(long x, long y, long z) {
        return lcm(x, gcd(y, z));
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}