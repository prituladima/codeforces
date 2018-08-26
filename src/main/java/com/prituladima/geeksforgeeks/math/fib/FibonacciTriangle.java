package com.prituladima.geeksforgeeks.math.fib;

public class FibonacciTriangle {

    public static void main(String[] args) {


        int n = 7;
        printFibonacciTriangle(n);
    }


    public static void printFibonacciTriangle(int deep){

        int[] dp = new int[deep * deep];



        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++){
            dp[i] = dp[i - 1] + dp[i-2];
        }


        int k = 1;
        for (int i = 1; i <= deep; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.printf("%d ", dp[k++]);
            }
            System.out.println();
        }





    }

}
