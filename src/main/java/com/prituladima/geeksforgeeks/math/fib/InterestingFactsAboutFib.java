package com.prituladima.geeksforgeeks.math.fib;


/**
 * @see "https://www.geeksforgeeks.org/interesting-facts-fibonacci-numbers/"
 */
public class InterestingFactsAboutFib {

    final static int period = 60;
    final static int amount = 700;

    public static void main(String[] args) {

        int[] dp = new int[amount];

        dp[0] = 0;
        dp[1] = 1;
        System.out.printf("%d ", dp[0]);
        System.out.printf("%d ", dp[1]);

        int t = 2;
        for (int i = 2; i < amount; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10;
            t++;
            System.out.printf("%d ", dp[i]);
            if (t == period) {
                System.out.println();
                t = 0;
            }
        }
    }

}
