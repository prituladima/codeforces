package com.prituladima.math;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

/**
 * @see "https://www.geeksforgeeks.org/mathematical-algorithms/"
 */
public class nCr {

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
        return binomialCoeff_rec(n - 1, k - 1) + binomialCoeff_rec(n - 1, k);
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
    int binomialCoeff_opt(int n, int k) {
        int C[] = new int[k + 1];

        // nC0 is 1
        C[0] = 1;

        for (int i = 1; i <= n; i++) {
            // Compute next row of pascal
            // triangle using the previous row
            for (int j = Math.min(i, k); j > 0; j--)
                C[j] = C[j] + C[j - 1];

        }
        return C[k];
    }


    /**
     * @see "https://www.geeksforgeeks.org/space-and-time-efficient-binomial-coefficient/"
     */
    int nCr_fast(int n, int k) {
        if (k == 0 || n == k) return 1;

        if (k > n - k)
            k = n - k;

        return fact(n) / (fact(n - k) * fact(k));
    }

    int fact(int n) {
        int m = 1;
        for (int i = 2; i <= n; i++) {
            m *= i;
        }
        return m;
    }


    /**
     * @see "https://www.geeksforgeeks.org/compute-ncr-p-set-2-lucas-theorem/"
     */
    // Lucas Theorem based function that returns nCr % p
// This function works like decimal to binary conversion
// recursive function.  First we compute last digits of
// n and r in base p, then recur for remaining digits
    int nCr_mod_p_lucas(int n, int r, int p) {
        // Base case
        if (r == 0) {
            return 1;
        }

        // Compute last digits of n and r in base p
        int ni = n % p, ri = r % p;

        // Compute result for last digits computed above, and
        // for remaining digits.  Multiply the two results and
        // compute the result of multiplication in modulo p.
        return (nCr_mod_p_lucas(n / p, r / p, p) * // Last digits of n and r
                nCr_mod_p_dp(ni, ri, p)) % p;  // Remaining digits

    }

    int nCr_mod_p_dp(int n, int r, int p) {

        if (n == r || r == 0) {
            return 1;
        }
        r = Math.min(r, n - r);

        int[][] dp = new int[n + 1][r + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                    dp[i][j] %= modulo;
                }
            }
        }
        return dp[n][r];
    }

    /**
     * @see "https://www.geeksforgeeks.org/space-and-time-efficient-binomial-coefficient/"
     * highest priority
     */
    int nCr(int n, int k) {


        k = Math.min(k, n - k);

        int ans = 1;
        for (int i = 0; i < k; i++) {
            ans *= n - i;
            ans /= i + 1;
            // ans %= 1000000007;
        }

        return ans;

    }

    int nCr_cached_fact(int n, int k) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int i = 1;

        while (true) {
            int last = list.get(list.size() - 1);
            int value = last * i;

            if (value / i != last) break;

            i++;
        }

        return list.get(n) / (list.get(k) * list.get(n - k));


    }


}
