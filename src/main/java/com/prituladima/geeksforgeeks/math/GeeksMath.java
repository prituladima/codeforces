package com.prituladima.geeksforgeeks.math;

import java.util.HashMap;
import java.util.Map;

import static java.lang.StrictMath.max;
import static java.lang.System.arraycopy;
import static java.util.Arrays.fill;

/**
 * @see "https://www.geeksforgeeks.org/modular-exponentiation-power-in-modular-arithmetic/"
 */
public class GeeksMath {

    public static long bpow(long x, long n, long mod) {
        return n != 0 ? n % 2 == 1 ? x * bpow(x, n - 1, mod) % mod : bpow(x * x % mod, n / 2, mod) : 1;
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


    /**
     * @see "https://www.geeksforgeeks.org/mathematical-algorithms/mathematical-algorithms-prime-factorization-divisors/"
     */

    boolean isPrime(long n) {
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

        return n != 1;
    }

    long sumOfDig(long n) {
        long sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    long largestPrimeFactor(long n) {
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

    long digitsInFactorizationWithExponental(long n) {
        Map<Long, Long> expCounter = new HashMap<>();
        while (n % 2 == 0) {
            expCounter.merge(2L, 1L, (x, y) -> x + y);
            n /= 2;
        }

        long f = 3;
        while (f * f <= n) {
            if (n % f == 0) {
                expCounter.merge(f, 1L, (x, y) -> x + y);
                n /= f;
            } else {
                f += 2;
            }
        }

        if (n != 1) expCounter.merge(n, 1L, (x, y) -> x + y);


        long sum = 0;
        for (long cur : expCounter.keySet()) {
            Long val = expCounter.get(cur);
            sum += digits(cur);
            sum += val != null && val > 1 ? digits(val) : 0;
        }

        return sum;
    }


    long digits(long n) {
        long amount = 0;
        while (n != 0) {
            amount++;
            n /= 10;
        }
        return amount;
    }

    static boolean[] prime(int n) {
        boolean[] prime = new boolean[n + 1];
        fill(prime, true);
        prime[1] = prime[0] = false;

        for (int i = 2; i <= n; i++)
            if (prime[i])
                if (i * 1L * i <= n)
                    for (int j = i * i; j <= n; j += i)
                        prime[j] = false;


        return prime;
    }

    public static long power_mod(long a, long pow, long mod) {
        long res = 1;
        a = a % mod;
        while (pow > 0) {
            if ((pow & 1) == 1)
                res = (res * a) % mod;
            pow = pow >> 1;
            a = (a * a) % mod;
        }
        return res;
    }


    long[][] matrixNxN_pow_modulo(long[][] P, long pow, long modulo) {

        if (pow <= 0) throw new IllegalArgumentException("Pow must be > 0");

        long[][] MUTABLE_COPY = deepCopy(P);
        long[][] RESULT = deepCopy(P);

        pow--;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                RESULT = multiplyNxN_modulo(RESULT, MUTABLE_COPY, modulo);
                pow--;
            } else {
                MUTABLE_COPY = multiplyNxN_modulo(MUTABLE_COPY, MUTABLE_COPY, modulo);
                pow >>= 1;
            }
        }

        return RESULT;
    }

    long[][] multiplyNxN_modulo(long[][] V, long[][] U, long modulo) {
        int n = assertSquareSizeAndGet(V, U);
        long[][] R = matrixNxN(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    R[i][j] += (V[i][k] % modulo) * (U[k][j] % modulo) % modulo;
                    R[i][j] %= modulo;
                }
            }
        }
        return R;
    }

    long[][] deepCopy(long[][] P) {
        int n = assertSquareSizeAndGet(P);
        long[][] RESULT = matrixNxN(n);
        for (int i = 0; i < P.length; i++) {
            arraycopy(P[i], 0, RESULT[i], 0, RESULT[i].length);
        }
        return RESULT;
    }

    int assertSquareSizeAndGet(long[][] V, long[][] U) {
        int n = assertSquareSizeAndGet(V);
        int m = assertSquareSizeAndGet(U);
        Error e = new AssertionError("Matrix must be square!");
        if (m == n) {
            return n;
        }
        throw e;
    }

    int assertSquareSizeAndGet(long[][] V) {
        int n = V.length;
        Error e = new AssertionError("Matrix must be square!");
        for (int i = 0; i < n; i++) {
            if (V[i].length != n) {
                throw e;
            }
        }
        return n;
    }

    long[][] matrixNxN(int n) {
        return new long[n][n];
    }


}