package com.prituladima.dp;

import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
            int[] arr = new int[sc.nextInt()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(kadane_max(arr, arr.length));



    }


    private static int kadane_max(int[] a, int n) {
        int max_so_far = 0;
        int max_ending_here = a[0];

        for (int i = 0; i < n; i++) {
            max_so_far += a[i];
            max_ending_here = Math.max(max_ending_here, max_so_far);
            max_so_far = Math.max(max_so_far, 0);
        }

        return max_ending_here;
    }

    private static int kadane_min(int[] a, int n) {
        int min_so_far = 0;
        int min_ending_here = a[0];

        for (int i = 0; i < n; i++) {
            min_so_far += a[i];
            min_ending_here = Math.min(min_ending_here, min_so_far);
            min_so_far = Math.min(min_so_far, 0);
        }

        return min_ending_here;
    }


    private static int[] kadane_min_full(int[] a, int n) {
        int min_l = 0, min_r = 0;

        int min_so_far = 0;
        int min_ending_here = a[0];

        int last_pos_sum = -1;
        for (int i = 0; i < n; i++) {
            min_so_far += a[i];
            if (min_ending_here > min_so_far) {
                min_ending_here = min_so_far;
                min_r = i;
                min_l = last_pos_sum + 1;
            }
            if (min_so_far > 0) {
                min_so_far = 0;
                last_pos_sum = i;
            }
        }
        return new int[]{min_ending_here, min_l, min_r};
    }

    private static int[] kadane_max_full(int[] a, int n) {
        int max_l = 0, max_r = 0;

        int max_so_far = 0;
        int max_from_sum = a[0];

        int last_min_sum = -1;
        for (int i = 0; i < n; i++) {
            max_so_far += a[i];

            if (max_from_sum < max_so_far) {
                max_from_sum = max_so_far;
                max_r = i;
                max_l = last_min_sum + 1;
            }

            if (max_so_far < 0) {
                max_so_far = 0;
                last_min_sum = i;
            }
        }

        System.out.println(max_l);
        System.out.println(max_r);
        return new int[]{max_from_sum, max_l, max_r};
    }


}
