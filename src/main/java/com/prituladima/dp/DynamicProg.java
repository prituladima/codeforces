package com.prituladima.dp;

import static java.lang.Math.max;

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


    public int lcs(char[] X, char[] Y, int m, int n) {
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

    @Override
    public int nCr(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }

        int[][] dp = new int[n + 1][r + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][r];
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
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }

        return dp[l][l];
    }


    private static int kadane_max(int[] a, int n) {
        int sum = 0;
        int max = a[0];

        for (int i = 0; i < n; i++) {
            sum += a[i];
            max = max(max, sum);
            sum = max(sum, 0);
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


    public int ugly(int n) {
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

    public int divisible235(int n) {
        return n / 2 + n / 3 + n / 5 - n / 6 - n / 15 - n / 10;
    }


    public int divisible2357(int n) {
        return (n / 2) + (n / 3) + (n / 5) + (n / 7)
                - (n / 6) - (n / 10) - (n / 14) - (n / 15) - (n / 21) - (n / 35)
                + (n / 30) + (n / 42) + (n / 70) + (n / 105)
                - (n / 210);
    }


    public int maxSquareSizeInMatrix(int[][] mtx, int n, int m) {
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


    /* Driver program to test above functions */
    public static void main(String args[]) {
        int n = 5832;
        System.out.println(new DynamicProg().divisible2357(n));
        System.out.println(new DynamicProg().divisible235(n));

    }
}