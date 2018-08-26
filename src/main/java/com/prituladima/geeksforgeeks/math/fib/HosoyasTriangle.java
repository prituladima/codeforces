package com.prituladima.geeksforgeeks.math.fib;

public class HosoyasTriangle {

    public static void main(String[] args) {
        printHosoyasTriangle(10);
    }

    static void printHosoyasTriangle(int deep) {
        long[][] dp = new long[deep][deep];
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[2][1] = 1;
        for (int i = 2; i < deep; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] == 0) {
                    if (j + 1 <= (i + 1) / 2) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 2][j];
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 2][j - 2];
                    }
                }
            }
        }
        for (int i = 0; i < deep; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d ", dp[i][j]);
            }
            System.out.println();
        }
    }
}