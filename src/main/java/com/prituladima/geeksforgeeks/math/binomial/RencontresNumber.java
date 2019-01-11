package com.prituladima.geeksforgeeks.math.binomial;


/**
 * @see "https://www.geeksforgeeks.org/mathematical-algorithms/"
 */
public class RencontresNumber {


    /**
     * @see "https://www.geeksforgeeks.org/modulo-1097-1000000007/"
     */
    final int modulo = 1000000007;

    /**
     * @see "https://www.geeksforgeeks.org/rencontres-number-counting-partial-derangements/"
     */
    int rencontres_number_rec(int n, int m) {
        if (n == 0 && m == 0) {
            return 1;
        }

        if (n == 1 && m == 0) {
            return 0;
        }

        if (m == 0) {
            return (n - 1) * (rencontres_number_rec(n - 1, 0) + rencontres_number_rec(n - 2, 0));
        }

        return nCr(n, m) * rencontres_number_rec(n - m, 0);
    }


    int rencontres_number_dp(int n, int m) {
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j <= i) {

                    // base case
                    if (i == 0 && j == 0)
                        dp[i][j] = 1;

                        // base case
                    else if (i == 1 && j == 0)
                        dp[i][j] = 0;

                    else if (j == 0)
                        dp[i][j] = (i - 1) * (dp[i - 1][0]
                                + dp[i - 2][0]);
                    else
                        dp[i][j] = nCr(i, j) * dp[i - j][0];
                }
            }
        }

        return dp[n][m];


    }


    int nCr(int n, int r) {
        int ans = 1;
        r = Math.min(r, n - r);
        for (int i = 0; i < r; i++) {
            ans *= n - i;
            ans /= i + 1;
        }
        return ans;
    }

}
