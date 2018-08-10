package com.prituladima.geeksforgeeks.math.fib.matrix;

import java.util.*;

import static java.lang.Math.max;
import static java.lang.System.arraycopy;

/**
 * [First Matrix]  [Second matrix]    [Third Matrix]
 * | F(n)   |  =  | a b c |  *        | F(n-1) |
 * | F(n-1) |     | 1 0 0 |           | F(n-2) |
 * | F(n-2) |     | 0 1 0 |           | F(n-3) |
 *
 * @see "https://www.geeksforgeeks.org/matrix-exponentiation/"
 */

public class GeneralisedFibonacciNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        GeneralisedFibonacciNumbers o = new GeneralisedFibonacciNumbers();
        while (t-- > 0) {

            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long c = scanner.nextLong();
            long n = scanner.nextLong();
            long m = scanner.nextLong();


            long ans = o.fibonacci_gen_mod(a, b, c, n - 1, m);

            System.out.println(ans);
        }


    }

    long fibonacci_mod(long a, long b, long n, long m) {

        if(n == 1) return 1;
        if(n == 2) return 1;

        long[][] M = {{a, b}, {1, 0}};
        long[][] P = matrix2x2_pow_modulo(M, n, m);

        return P[0][1];
    }


    long fibonacci_gen_mod(long a, long b, long c, long n, long m) {

        if(n==1) return 1;
        if(n==2) return 0;

        long[][] M = {{a, b, c}, {1, 0, 0}, {0, 1, 0}};
        long[][] P = matrix3x3_pow_modulo(M, n-1, m);

        System.out.println(Arrays.deepToString(P));

        return (P[0][0] + P[0][1] + P[0][2]) % m;

    }


    static long power_mod(long a, long pow, long mod) {
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

    long[][] matrix3x3_pow_modulo(long[][] P, long pow, long modulo) {
        if (pow < 1) throw new IllegalArgumentException("Pow must be > 0");

        long[][] MUTABLE_COPY = matrix3x3();
        long[][] RESULT = identity3x3();


        for (int i = 0; i < P.length; i++) {
            arraycopy(P[i], 0, MUTABLE_COPY[i], 0, MUTABLE_COPY[i].length);
            arraycopy(P[i], 0, RESULT[i], 0, RESULT[i].length);
        }

        pow--;
        while (pow > 0) {
            if (pow % 2 == 1) {
                RESULT = multiply3x3_modulo(RESULT, MUTABLE_COPY, modulo);
                pow--;
            } else {
                MUTABLE_COPY = multiply3x3_modulo(MUTABLE_COPY, MUTABLE_COPY, modulo);
                pow /= 2;
            }
        }

        return RESULT;


    }


    /**
     * [1 1]^n   [F(n+1) F(n)  ]
     * [1 0]   = [F(n)   F(n-1)].
     */
    long[][] matrix2x2_pow_modulo(long[][] P, long pow, long modulo) {

        if (pow < 1) throw new IllegalArgumentException("Pow must be > 0");

        long[][] MUTABLE_COPY = matrix2x2();
        long[][] RESULT = identity2x2();


        for (int i = 0; i < P.length; i++) {
            arraycopy(P[i], 0, MUTABLE_COPY[i], 0, MUTABLE_COPY[i].length);
            arraycopy(P[i], 0, RESULT[i], 0, RESULT[i].length);
        }

        pow--;
        while (pow > 0) {
            if (pow % 2 == 1) {
                RESULT = multiply2x2_modulo(RESULT, MUTABLE_COPY, modulo);
                pow--;
            } else {
                MUTABLE_COPY = multiply2x2_modulo(MUTABLE_COPY, MUTABLE_COPY, modulo);
                pow /= 2;
            }
        }

        return RESULT;
    }

    long[][] multiply2x2_modulo(long[][] V, long[][] U, long modulo) {
        long[][] R = matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    R[i][j] += (V[i][k] % modulo) * (U[k][j] % modulo) % modulo;
                    R[i][j] %= modulo;
                }
            }
        }
        return R;
    }

    long[][] multiply3x3_modulo(long[][] V, long[][] U, long modulo) {
        long[][] R = matrix3x3();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    R[i][j] += (V[i][k] % modulo) * (U[k][j] % modulo) % modulo;
                    R[i][j] %= modulo;
                }
            }
        }
        return R;
    }

    long[][] matrix2x2() {
        return new long[2][2];
    }

    long[][] matrix3x3() {
        return new long[3][3];
    }

    long[][] identity2x2() {
        return new long[][]{{1, 0}, {0, 1}};
    }

    long[][] identity3x3() {
        return new long[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
    }


}
