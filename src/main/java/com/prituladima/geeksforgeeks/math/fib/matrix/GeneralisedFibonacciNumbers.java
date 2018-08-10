package com.prituladima.geeksforgeeks.math.fib.matrix;

import java.util.Scanner;

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

            long n = scanner.nextLong();

//            long ans = o.fib_gen(n);

//            System.out.println(ans);
        }


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

    long[][] matrix2x2() {
        return new long[2][2];
    }

    long[][] identity2x2() {
        return new long[][]{{1, 0}, {0, 1}};
    }


}
