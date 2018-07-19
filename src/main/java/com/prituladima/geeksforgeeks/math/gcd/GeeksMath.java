package com.prituladima.geeksforgeeks.math.gcd;

/**
 * @see "https://www.geeksforgeeks.org/modular-exponentiation-power-in-modular-arithmetic/"
 */
public class GeeksMath {

    long bin_pow(long a, long n) {
        long res = 1;
        while (n > 0) {
            res *= (n & 1) != 0 ? a : 1;
            a *= a;
            n >>= 1;
        }
        return res;
    }

    long bin_pow_mod(long a, long n, long modulo) {
        long res = 1;
        a %= modulo;
        while (n > 0) {
            res = (n & 1) != 0 ? (res * a) % modulo : 1;
            n >>= 1;
            a *= a;
            a %= modulo;
        }
        return res;
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    long save_mod(long x, long m) {
        return (x % m + m) % m;
    }

    long gcdExtended(long a, long b, long[] x) {
        // Base Case
        if (a == 0) {
            x[0] = 0;
            x[1] = 1;
            return b;
        }

        long[] t = {1, 1}; // To store results of recursive call
        long gcd = gcdExtended(b % a, a, t);

        // Update t using results of recursive
        // call

        x[0] = t[1] - (b / a) * t[0];
        x[1] = t[0];
        return gcd;
    }

}