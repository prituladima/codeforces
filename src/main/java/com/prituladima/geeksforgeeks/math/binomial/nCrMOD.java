package com.prituladima.geeksforgeeks.math.binomial;

import static java.lang.Math.min;

/**
 * @see "https://www.geeksforgeeks.org/mathematical-algorithms/"
 */
public class nCrMOD {

    /**
     * @see "https://www.geeksforgeeks.org/modulo-1097-1000000007/"
     */
    final int modulo = 1000000007;

    /**
     * @see "https://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/"
     */
    // Returns value of Binomial Coefficient C(n, k)
    int binomialCoeff_rec(int n, int k) {
        // Base Cases
        if (k == 0 || k == n)
            return 1;

        // Recur
        return (binomialCoeff_rec(n - 1, k - 1) + binomialCoeff_rec(n - 1, k)) % modulo;
    }


    /**
     * @see "https://www.geeksforgeeks.org/compute-ncr-p-set-1-introduction-and-dynamic-programming-solution/"
     */
    // Returns value of Binomial Coefficient C(n, k)
    int binomialCoeff_dp(int n, int k) {
        int C[][] = new int[n + 1][k + 1];
        int i, j;

        // Calculate  value of Binomial Coefficient in bottom up manner
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= min(i, k); j++) {
                // Base Cases
                if (j == 0 || j == i)
                    C[i][j] = 1;

                    // Calculate value using previosly stored values
                else
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];

                C[i][j] %= modulo;
            }
        }

        return C[n][k];
    }

    /**
     * @see "https://www.geeksforgeeks.org/space-and-time-efficient-binomial-coefficient/"
     */
    int binomialCoeff_dp_opt(int n, int k) {
        int C[] = new int[k + 1];

        // nC0 is 1
        C[0] = 1;

        for (int i = 1; i <= n; i++) {
            // Compute next row of pascal
            // triangle using the previous row
            for (int j = Math.min(i, k); j > 0; j--)
                C[j] = (C[j] + C[j - 1]) % modulo;

        }
        return C[k];
    }
}
