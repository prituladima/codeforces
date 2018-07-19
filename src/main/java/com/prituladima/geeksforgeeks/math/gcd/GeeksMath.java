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

}