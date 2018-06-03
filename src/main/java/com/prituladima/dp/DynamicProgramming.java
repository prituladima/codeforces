package com.prituladima.dp;

import static java.lang.Math.max;

/**
 * @see "https://www.geeksforgeeks.org/dynamic-programming/"
 */
class DynamicProgramming {

    /**
     * @see "https://www.geeksforgeeks.org/modulo-1097-1000000007/"
     */
    final int modulo = 1000000007;


    /**
     * @see "https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/"
     */
    int fib(int n) {
        if (n == 1 || n == 2) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % modulo;
        return dp[n];
    }

    /**
     * @see "https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/"
     */
    int fib_fast(int n) {
        int F[][] = new int[][]{{1, 1}, {1, 0}};
        if (n == 0)
            return 0;
        power(F, n - 1);

        return F[0][0];
    }

    void multiply(int F[][], int M[][]) {
        int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    /* Optimized version of power() in method 4 */
    void power(int F[][], int n) {
        if (n == 0 || n == 1)
            return;
        int M[][] = new int[][]{{1, 1}, {1, 0}};

        power(F, n / 2);
        multiply(F, F);

        if (n % 2 != 0)
            multiply(F, M);
    }

    /**
     * @see "https://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/"
     */
    int nCr(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }

        int[][] dp = new int[n + 1][r + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % modulo;
                }
            }
        }

        return dp[n][r];
    }

    /**
     * @see "https://practice.geeksforgeeks.org/problems/longest-common-subsequence/0"
     */
    int lcs(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }


    /**
     * @see "https://www.geeksforgeeks.org/longest-repeated-subsequence/"
     */
    int lrs(char[] s, int l) {
        int[][] dp = new int[l + 1][l + 1];

        for (int i = 0; i <= l; i++)
            for (int j = 0; j <= l; j++)
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s[i - 1] == s[j - 1] && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }

        return dp[l][l];
    }

    /**
     * @see "https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/"
     */
    int kadane_max(int[] a, int n) {
        int sum = 0;
        int max = a[0];

        for (int i = 0; i < n; i++) {
            sum += a[i];
            max = max(max, sum);
            sum = max(sum, 0);
        }

        return max;
    }

    int kadane_min(int[] a, int n) {
        int sum = 0;
        int min = a[0];

        for (int i = 0; i < n; i++) {
            sum += a[i];
            min = Math.min(min, sum);
            sum = Math.min(sum, 0);
        }

        return min;
    }

    int[] kadane_max_full(int[] a, int n) {
        int maxL = 0, maxR = 0;

        int nonNegativeSum = 0;
        int max = a[0];

        int last_min_sum = -1;
        for (int i = 0; i < n; i++) {
            nonNegativeSum += a[i];

            if (max < nonNegativeSum) {
                max = nonNegativeSum;
                maxR = i;
                maxL = last_min_sum + 1;
            }

            if (nonNegativeSum < 0) {
                nonNegativeSum = 0;
                last_min_sum = i;
            }
        }

        return new int[]{max, maxL, maxR};
    }


    int[] kadane_min_full(int[] a, int n) {
        int minL = 0, minR = 0;

        int nonPositiveSum = 0;
        int min = a[0];

        int last_pos_sum = -1;
        for (int i = 0; i < n; i++) {
            nonPositiveSum += a[i];
            if (min > nonPositiveSum) {
                min = nonPositiveSum;
                minR = i;
                minL = last_pos_sum + 1;
            }
            if (nonPositiveSum > 0) {
                nonPositiveSum = 0;
                last_pos_sum = i;
            }
        }
        return new int[]{min, minL, minR};
    }

    /**
     * @see ""
     */
    int ugly(int n) {
        int nearest = 1;
        int next2 = 2, next3 = 3, next5 = 5;
        int i2 = 0, i3 = 0, i5 = 0;

        int[] ugly = new int[n];
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            nearest = Math.min(Math.min(next2, next3), next5);
            ugly[i] = nearest;

            if (nearest == next2) {
                i2++;
                next2 = ugly[i2] * 2;
            }
            if (nearest == next3) {
                i3++;
                next3 = ugly[i3] * 3;
            }
            if (nearest == next5) {
                i5++;
                next5 = ugly[i5] * 5;
            }
        }
        return nearest;
    }


    int divisible235(int n) {
        return n / 2 + n / 3 + n / 5 - n / 6 - n / 15 - n / 10;
    }

    /**
     * @see ""
     */
    int divisible2357(int n) {
        return (n / 2) + (n / 3) + (n / 5) + (n / 7)
                - (n / 6) - (n / 10) - (n / 14) - (n / 15) - (n / 21) - (n / 35)
                + (n / 30) + (n / 42) + (n / 70) + (n / 105)
                - (n / 210);
    }

    /**
     * @see ""
     */
    int maxSquareSizeInMatrix(int[][] mtx, int n, int m) {
        int[][] sum = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    sum[i][j] = mtx[i][j];
                } else if (mtx[i][j] == 1) {
                    sum[i][j] = 1 + Math.min(Math.min(sum[i - 1][j], sum[i][j - 1]), sum[i - 1][j - 1]);
                } else {
                    sum[i][j] = 0;
                }

                max = Math.max(max, sum[i][j]);
            }
        }
        return max;
    }

    /**
     * todo
     * @see ""
     */
}