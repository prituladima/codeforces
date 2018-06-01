package com.prituladima.dp;

import java.util.Arrays;

public class DynamicProg implements DPAlgo {

    public int fib(int n) {
        int[] res = new int[n];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n - 1];
    }


    public int lcs_lenght(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

    @Override
    public int bin_coef(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][k];
    }


    @Override
    public int lrs_lenght(char[] s, int l) {
        int[][] dp = new int[l + 1][l + 1];

        for (int i = 0; i <= l; i++)
            for (int j = 0; j <= l; j++)
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s[i - 1] == s[j - 1] && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

        return dp[l][l];
    }


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

    /* Utility function to get max of 2 integers */
    int max(int a, int b) {
        return (a > b) ? a : b;
    }


    public static void main(String[] args) {

        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(Arrays.toString(kadane_max_full(arr, arr.length)));

    }


    private static int kadane_max(int[] a, int n) {
        int sum = 0;
        int max = a[0];

        for (int i = 0; i < n; i++) {
            sum += a[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }

    private static int kadane_min(int[] a, int n) {
        int sum = 0;
        int min = a[0];

        for (int i = 0; i < n; i++) {
            sum += a[i];
            min = Math.min(min, sum);
            sum = Math.min(sum, 0);
        }

        return min;
    }

    private static int[] kadane_max_full(int[] a, int n) {
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


    private static int[] kadane_min_full(int[] a, int n) {
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


}
