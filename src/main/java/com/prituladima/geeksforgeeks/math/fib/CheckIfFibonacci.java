package com.prituladima.geeksforgeeks.math.fib;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @see "https://www.geeksforgeeks.org/check-number-fibonacci-number/"
 */
public class CheckIfFibonacci {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int[] dp = new int[20];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < 20; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            set.add(dp[i]);
            if (dp[i] > 100) break;
        }


        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while (t-- > 0) {
            System.out.println(isFibonacci(s.nextInt()) ? "Yes" : "No");
        }

    }


    // Data utility function that returns true if x is perfect square
   static boolean isPerfectSquare(int x)
    {
        int s = (int)Math.sqrt(x);
        return (s*s == x);
    }

    // Returns true if n is a Fibinacci Number, else false
    static boolean isFibonacci(int n)
    {
        // n is Fibinacci if one of 5*n*n + 4 or 5*n*n - 4 or both
        // is a perferct square
        return isPerfectSquare(5*n*n + 4) ||
                isPerfectSquare(5*n*n - 4);
    }

}