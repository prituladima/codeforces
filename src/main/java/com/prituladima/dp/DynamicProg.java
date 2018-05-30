package com.prituladima.dp;

public class DynamicProg implements DPAlgo {

    public int fib(int n) {
        int[] res = new int[n];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n-1];
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
    public int lrs_lenght(char[] S) {
        return 0;
    }
}
