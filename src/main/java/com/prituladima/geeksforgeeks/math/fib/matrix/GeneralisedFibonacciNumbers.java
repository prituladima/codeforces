package com.prituladima.geeksforgeeks.math.fib.matrix;

import java.util.*;

import static java.lang.System.arraycopy;

/**
 * The homogeneous differential equation
 * F[0] = 0;
 * F[1] = 1;
 * f[2] = 1;
 * F[n] = a*F(n-1) + b*F(n-2) + c*F(n-3).
 * [First Matrix]  [Second matrix]    [Third Matrix]
 * | F(n)   |  =  | a b c |  *        | F(n-1) |
 * | F(n-1) |     | 1 0 0 |           | F(n-2) |
 * | F(n-2) |     | 0 1 0 |           | F(n-3) |
 * <p>
 * <p>
 * The inhomogeneous differential equation
 * F(1) = 1
 * F(2) = 1
 * F[n] = a*F(n-1) + b*F(n-2) + c.
 * [First Matrix]  [Second matrix]    [Third Matrix]
 * | F(n)   |  =  | a b 1 |  *        | F(n-1) |
 * | F(n-1) |     | 1 0 0 |           | F(n-2) |
 * | c      |     | 0 0 1 |           | c      |
 *
 * @see "https://www.geeksforgeeks.org/matrix-exponentiation/"
 * @see "https://practice.geeksforgeeks.org/problems/generalised-fibonacci-numbers/0"
 */

public class GeneralisedFibonacciNumbers {


    /**
     * CODE REVIEW OK
     * TEST OK
     */
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
            long ans = o.fibonacci_gen_mod(a, b, c, n, m);
            System.out.println(ans);
        }
    }

    long fibonacci_gen_mod(long a, long b, long c, long n, long m) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        long[][] M =
                {
                        {a, b, 1},
                        {1, 0, 0},
                        {0, 0, 1}
                };
        long[] V = {1, 1, c};
        long[][] P = matrixNxN_pow_modulo(M, n - 2, m);

        return (V[0] * P[0][0]
                + V[1] * P[0][1]
                + V[2] * P[0][2]) % m;
    }

    /**
     * CODE REVIEW OK
     * TEST OK
     */
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


    /**
     * CODE REVIEW OK
     * TEST OK
     */
    long[][] deepCopy(long[][] P) {
        int n = assertSquareSizeAndGet(P);
        long[][] RESULT = matrixNxN(n);
        for (int i = 0; i < P.length; i++) {
            arraycopy(P[i], 0, RESULT[i], 0, RESULT[i].length);
        }
        return RESULT;
    }

    /**
     * CODE REVIEW OK
     * TEST OK
     */
    int assertSquareSizeAndGet(long[][] V, long[][] U) {
        int n = assertSquareSizeAndGet(V);
        int m = assertSquareSizeAndGet(U);
        Error e = new AssertionError("Matrix V and U are not the same square!");
        if (m == n) {
            return n;
        }
        throw e;
    }

    /**
     * CODE REVIEW OK
     * TEST OK
     */
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

    /**
     * CODE REVIEW OK
     * TEST OK
     */
    long[][] matrixNxN(int n) {
        return new long[n][n];
    }

}